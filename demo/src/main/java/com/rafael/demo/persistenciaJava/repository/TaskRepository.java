package com.rafael.demo.persistenciaJava.repository;

import com.rafael.demo.persistenciaJava.Class.Task;
import com.rafael.demo.persistenciaJava.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByPriority(Priority priority);
}
