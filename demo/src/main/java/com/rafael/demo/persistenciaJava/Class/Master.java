package com.rafael.demo.persistenciaJava.Class;

import com.rafael.demo.persistenciaJava.model.Priority;
import com.rafael.demo.persistenciaJava.repository.ProjectRepository;
import com.rafael.demo.persistenciaJava.repository.TaskRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Master {
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;
    private Scanner key = new Scanner(System.in);

    public Master(ProjectRepository projectRepository,TaskRepository taskRepository){
        this.projectRepository=projectRepository;
        this.taskRepository= taskRepository;
    }
    public Master(){}

    public void menu(){
        int num = -1;
        while (num!=0) {
            System.out.println("""
                    1-Cadastrar projetos:
                    2-Cadastrar tarefas:
                    3-Listar projetos:
                    4-Listar tarefas por projeto:
                    5-Buscar tarefas por prioridade:
                    6-Tarefas Completa
                    0-SAIR\s
                    """);
            System.out.println("WHAT DO YOU WANT TO DO TODAY?");
            num = key.nextInt();
            this.willDo(num);

        }

    }

    private void willDo(int num) {
        switch (num){
            case 1:
                this.registerProject(this.projectRepository);
                break;
            case 2:
                this.registerTask(this.taskRepository,this.projectRepository);
                break;
            case 3:
                this.listProjects(this.projectRepository);
                break;
            case 4:
                this.listTaskProjects(this.projectRepository);
                break;
            case 5:
                this.listTaskPriority(this.taskRepository);
                break;
            case 6:
                this.completedTask(this.taskRepository);
                break;
            case 0:
                System.out.println("SAINDO.........");
                break;
            default:
                throw new RuntimeException("Invalid option");

        }
    }
    private void completedTask(TaskRepository taskRepository){
        Task task=  taskRepository.findById(1L).get();
        task.setCompleted(true);
        taskRepository.save(task);
    }

    private void listTaskPriority(TaskRepository taskRepository) {
        taskRepository.findByPriority(Priority.HIGH).forEach(System.out::println);
    }

    private void listTaskProjects(ProjectRepository projectRepository) {
        projectRepository.findAll().forEach(s-> System.out.println("NAME PROJECTS: "+s.getName()+" TASKS: "+s.getTasks()));
    }

    private void listProjects(ProjectRepository projectRepository) {
        projectRepository.findAll().forEach(System.out::println);
    }

    private void registerTask(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.listProjects(projectRepository);
        System.out.println("NAME PROJECT");
        Optional<Project> project= projectRepository.findByNameContainingIgnoreCase(key.next());
        project.ifPresent(p->taskRepository.save(new Task("CRIADO","SLA",LocalDate.now(), Priority.HIGH,false,p)));
        System.out.println("Task registered successfully");
    }

    private void registerProject(ProjectRepository projectRepository) {
        System.out.println("PROJECT NAME ?");
        String name= key.next();
        System.out.println("Project description");
        String description = key.nextLine();
        projectRepository.save(new Project(name,description, LocalDate.now()));
        System.out.println("Project registered successfully");
    }
}
