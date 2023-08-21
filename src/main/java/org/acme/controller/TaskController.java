package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.acme.dto.TaskDto;
import org.acme.entity.Task;
import org.acme.service.TaskService;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestPath;

import java.util.ArrayList;
import java.util.List;

@Path("/task")
public class TaskController {
    @Inject
    TaskService taskService;

    @GET()
    public List<Task> retrieveTasks(){
        List<Task> tasks = new ArrayList<>();
        try{
            tasks = taskService.FindAllTasks();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    @GET()
    @Path("{id}")
    public Task retrieveTaskById(@RestPath Long id){
        try{
            return taskService.FindTaskById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @POST
    @Transactional
    public void addTask(TaskDto task){
        taskService.AddTask(task);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void updateTask(@RestPath Long id, Task task) throws Exception {
        taskService.UpdateTask(id, task);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void removeTask(@RestPath Long id) throws Exception {
        taskService.RemoveTask(id);
    }
}
