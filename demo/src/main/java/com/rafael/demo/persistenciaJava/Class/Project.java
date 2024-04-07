package com.rafael.demo.persistenciaJava.Class;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name",length = 30,unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private LocalDate date;
    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Task> tasks;

    public Project(){}

    public Project(String name,String description,LocalDate date){
        this.name = name;
        this.description = description;
        this.date = date;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date=date;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
