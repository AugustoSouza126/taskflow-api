package com.augusto.taskflow.dto;

import com.augusto.taskflow.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDTO {

    @NotBlank(message = "Title is required")
    @Size(max = 100)
    private String title;

    @Size(max = 255)
    private String description;

    private TaskStatus status;
}