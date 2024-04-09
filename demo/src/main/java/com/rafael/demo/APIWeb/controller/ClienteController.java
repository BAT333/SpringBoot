package com.rafael.demo.APIWeb.controller;

import com.rafael.demo.APIWeb.model.RecordTask;
import com.rafael.demo.persistenciaJava.model.Priority;
import com.rafael.demo.persistenciaJava.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    TaskRepository taskRepository;
    @GetMapping
    public List<RecordTask> Hellou(){
        return taskRepository.findByPriority(Priority.HIGH).stream().map(RecordTask::new).collect(Collectors.toList());
    }
}
