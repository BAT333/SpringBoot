package com.rafael.demo.APIWeb.user.repository;

import com.rafael.demo.APIWeb.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByLogin(String username);
}
