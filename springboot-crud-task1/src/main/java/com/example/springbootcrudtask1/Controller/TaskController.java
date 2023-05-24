package com.example.springbootcrudtask1.Controller;


import com.example.springbootcrudtask1.Entity.Task;
import com.example.springbootcrudtask1.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;


    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task){
        return service.saveTask(task);
    }
    @PostMapping("/addTasks")
    public List<Task> addTasks(@RequestBody List<Task> tasks){
        return service.saveTasks(tasks);
    }

    @GetMapping("/tasks")
    public List<Task> findAllTasks(){
        return service.getTasks();
    }

    @GetMapping("/tasksById/{id}")
    public Task findTaskById(@PathVariable int id){
        return service.getTasksById(id);
    }

    @GetMapping("/tasksByTitle/{title}")
    public Task findTaskByTitle(@PathVariable String title){
        return service.getTasksByTitle(title);
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        return service.deleteTask(id);
    }

}
