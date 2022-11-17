package com.whiletrue.tododemo.dto;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class TaskResponse {

    private Long id;
    private String name;
    private String description;
    private Instant dueDateTime;
    private String createdBy;
    private String assignedTo;
    private boolean completed;
    private LocalDateTime created;
    private LocalDateTime updated;

    public TaskResponse(Long id, Task task) {
        this.id = id;
        this.name = task.getName();
        this.description = task.getDescription();
        this.dueDateTime = task.getDueDateTime();
        this.createdBy = task.getCreatedBy();
        this.assignedTo = task.getAssignedTo();
        this.completed = task.isCompleted();
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

}
