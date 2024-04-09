package com.rafael.demo.APIWeb.model;

import com.rafael.demo.persistenciaJava.Class.Task;

public record RecordTask(
        String name,
        boolean completo
) {
    public RecordTask(Task task){
        this(task.getTitle(),task.getCompleted());
    }
}
