package com.rafael.demo.persistenciaJava.Class;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.rafael.demo.persistenciaJava.model.Priority;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "task")
public class Task{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "title",nullable = true,length = 30)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private LocalDate duedate;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Column(name = "completed")
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "id_project ")
    private Project project;
    public Task() {}
    public Task(String title,String description, LocalDate duedate,Priority priority,Boolean completed,Project project){
        this.title =title;
        this.description = description;
        this.duedate =duedate;
        this.priority =priority;
        this.completed = completed;
        this.project =project;
    }

    public Long getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title =title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description =description;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duedate=" + duedate +
                ", priority=" + priority +
                ", completed=" + completed +
                ", project=" + project +
                '}';
    }

    public void completa() {
        this.completed=true;
    }
}
