package com.augusto.taskflow.service;

import com.augusto.taskflow.model.Task;
import com.augusto.taskflow.repository.TaskRepository;
import com.augusto.taskflow.exception.TaskNotFoundException;
import org.springframework.stereotype.Service;
import com.augusto.taskflow.dto.TaskRequestDTO;
import com.augusto.taskflow.dto.TaskResponseDTO;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public TaskResponseDTO save(TaskRequestDTO dto) {

        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());

        Task savedTask = repository.save(task);

        return new TaskResponseDTO(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.getStatus()
        );
    }

    public Task findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
    }

    public Task update(Long id, Task updatedTask) {

        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());

        return repository.save(task);
    }

    public void delete(Long id) {

        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        repository.delete(task);
    }
}