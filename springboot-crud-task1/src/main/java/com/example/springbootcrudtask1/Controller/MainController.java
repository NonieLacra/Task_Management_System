package com.example.springbootcrudtask1.Controller;

import com.example.springbootcrudtask1.Entity.Task;
import com.example.springbootcrudtask1.Repository.TaskRepository;
import com.example.springbootcrudtask1.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks",tasks);
        return "index";
    }
    @GetMapping("/newTaskForm")
    public String newTaskForm(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "new_task";
    }
    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("newtasks")Task newTask){
        taskRepository.save(newTask);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String newUpdateTaskForm(@PathVariable (value = "id") int id, Model model){
        Task task = taskRepository.getById(id);
        model.addAttribute("task", task);
        return "update_task";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable (value = "id") int id){
        this.taskRepository.deleteById(id);
        return "redirect:/";
    }

}
