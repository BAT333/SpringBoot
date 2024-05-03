package com.rafael.demo.APIWeb.user;

import jakarta.persistence.*;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "logins")
    private String login;
    @Column(name = "passwords")
    private String password;

    public User(){
    }
    public User(String login, String password){
        this.login = login;
        this.password =password;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;
    }
    public void setPasswordsUser(String password){
        this.password = password;
    }
    public String getPasswordUser(){
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(this == obj)return true;
        if(this.getClass() != obj.getClass())return false;
        User user = (User) obj;
        return this.id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
