package com.springsecurity.demospringsecurity.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
public class User implements UserDetails {

    private Integer userSeq;
    private String username;
    private String password;
    private String email;
    private String contactNo;
    private String firstName;
    private String secondName;
    private boolean enabled;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private Set<GrantedAuthority> authorities =  new HashSet<>();
    private Boolean rootEnable;


    @Id
    @Column(name = "usr_id", nullable = false, precision = 0, unique = true)
    public Integer getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(Integer userSeq) {
        this.userSeq = userSeq;
    }

    @Basic
    @Column(name = "usr_username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "usr_password", nullable = false, length = 250)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "usr_email", nullable = false, length = 250)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "usr_contact_no", length = 20)
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Basic
    @Column(name = "usr_first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "usr_second_name")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    @Basic
    @Column(name = "usr_enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    @Basic
    @Column(name = "usr_account_locked")
    public boolean isAccountNonLocked() {
        return !accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Basic
    @Column(name = "usr_account_expired")
    public boolean isAccountNonExpired() {
        return !accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Basic
    @Column(name = "usr_credentials_expired")
    public boolean isCredentialsNonExpired() {
        return !credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Basic
    @Column(name = "usr_root_enable")
    public Boolean getRootEnable() {
        return rootEnable;
    }

    public void setRootEnable(Boolean rootEnable) {
        this.rootEnable = rootEnable;
    }

}
