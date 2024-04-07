package com.rafael.demo.persistenciaJava.repository;

import com.rafael.demo.persistenciaJava.Class.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    Optional<Project> findByNameContainingIgnoreCase(String next);
}
