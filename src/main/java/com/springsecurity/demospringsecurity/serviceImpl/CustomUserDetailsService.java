package com.springsecurity.demospringsecurity.serviceImpl;

import com.springsecurity.demospringsecurity.entity.User;
import com.springsecurity.demospringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service(value = "userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String input) {
        Optional<User> user;

        user = this.userRepository.findByUsernameIgnoreCase(input);

        if (!user.isPresent()) {
            throw new BadCredentialsException("Bad credentials");
        }
        new AccountStatusUserDetailsChecker().check(user.get());
        user.get().setAuthorities(this.getAuthorities());
        return user.get();
    }

    Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return authorities;
    }


}
