package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.TaskDto;
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

    public Task FindTaskById(Long id){
        return taskRepository.findById(id);
    }

    public void AddTask(TaskDto task){
        Task taskModel = new Task();
        taskModel.setName(task.Nome);
        taskRepository.persist(taskModel);
    }

    public void UpdateTask(Long id, Task task) throws Exception{
        Task oldTask = FindTaskById(id);
        if(oldTask == null) throw new Exception("Id não encontrado.");
        oldTask.setName(task.getName());
        taskRepository.persist(oldTask);
    }

    public void RemoveTask(Long id) throws Exception{
        Task oldTask = FindTaskById(id);
        if(oldTask == null) throw new Exception("Id não encontrado.");
        taskRepository.delete(oldTask);
    }
}
