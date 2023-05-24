package com.example.springbootcrudtask1.Service;

import com.example.springbootcrudtask1.Entity.Task;
import com.example.springbootcrudtask1.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> saveTasks(List<Task> tasks){
        return taskRepository.saveAll(tasks);
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Task getTasksById(int id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task getTasksByTitle(String title){
        return taskRepository.findByTitle(title);
    }

    public String deleteTask(int id){
        taskRepository.deleteById(id);
        return "Task " + id + "has been deleted!";
    }

    public Task updateTask(Task task){
        Task existingTask = taskRepository.findById(task.getId()).orElse(null);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setCompleted(task.getCompleted());
        return taskRepository.save(existingTask);
    }


}