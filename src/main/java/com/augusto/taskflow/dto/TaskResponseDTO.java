package com.augusto.taskflow.dto;

import com.augusto.taskflow.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskResponseDTO {

    private Long id;

    private String title;

    private String description;

    private TaskStatus status;
}