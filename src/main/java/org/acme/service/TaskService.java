package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Task;
import org.acme.repository.TaskRepository;

import java.util.List;

@ApplicationScoped
public class TaskService {
    @Inject
    TaskRepository taskRepository;

    public List<Task> FindAllTasks(){
        return taskRepository.findAll().list();
    }

    public void AddTask(Task task){
        taskRepository.persist(task);
    }
}
