package com.augusto.taskflow.service;

import com.augusto.taskflow.model.Task;
import com.augusto.taskflow.model.TaskStatus;
import com.augusto.taskflow.model.User;
import com.augusto.taskflow.repository.TaskRepository;
import com.augusto.taskflow.exception.TaskNotFoundException;
import com.augusto.taskflow.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.augusto.taskflow.dto.TaskRequestDTO;
import com.augusto.taskflow.dto.TaskResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final UserRepository userRepository;

    public TaskService(
            TaskRepository repository,
            UserRepository userRepository) {

        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<TaskResponseDTO> findAll() {

        User user = getAuthenticatedUser();

        return repository.findByUser(user)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public List<TaskResponseDTO> findByStatus(TaskStatus status) {

        return repository.findByStatus(status)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public TaskResponseDTO save(TaskRequestDTO dto) {

        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setUser(getAuthenticatedUser());

        Task savedTask = repository.save(task);

        return toResponseDTO(savedTask);
    }

    public TaskResponseDTO findById(Long id) {

        Task task = repository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found"));

        User user = getAuthenticatedUser();

        if (!task.getUser().getId().equals(user.getId())) {
            throw new TaskNotFoundException("Task not found");
        }

        return toResponseDTO(task);
    }

    public Task update(Long id, Task updatedTask) {

        Task task = repository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found"));

        User user = getAuthenticatedUser();

        if (!task.getUser().getId().equals(user.getId())) {
            throw new TaskNotFoundException("Task not found");
        }

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

    private TaskResponseDTO toResponseDTO(Task task) {

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }

    public Page<TaskResponseDTO> findAllPaged(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable)
                .map(this::toResponseDTO);
    }

    private User getAuthenticatedUser() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }
}