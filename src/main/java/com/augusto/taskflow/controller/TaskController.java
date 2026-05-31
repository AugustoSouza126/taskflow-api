package com.augusto.taskflow.controller;

import com.augusto.taskflow.dto.TaskRequestDTO;
import com.augusto.taskflow.dto.TaskResponseDTO;
import com.augusto.taskflow.model.Task;
import com.augusto.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> findAll() {
        return service.findAll();
    }

    @PostMapping
    public TaskResponseDTO save(
            @Valid @RequestBody TaskRequestDTO dto) {

        return service.save(dto);
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Task update(
            @PathVariable Long id,
            @Valid @RequestBody Task task) {

        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

