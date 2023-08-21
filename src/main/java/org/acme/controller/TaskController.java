package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.entity.Task;
import org.acme.service.TaskService;

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

    @POST
    @Transactional
    public void addTask(Task task){
        taskService.AddTask(task);
    }
}
