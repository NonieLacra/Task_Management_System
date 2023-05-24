package com.example.springbootcrudtask1.Repository;

import com.example.springbootcrudtask1.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByTitle(String title);

}
