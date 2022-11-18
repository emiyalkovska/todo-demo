package com.whiletrue.tododemo.dto;

import com.whiletrue.tododemo.entity.TaskEntity;
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

    public TaskResponse(TaskEntity taskEntity) {
        this.id = taskEntity.getId();
        this.name = taskEntity.getName();
        this.description = taskEntity.getDescription();
        this.dueDateTime = taskEntity.getDueDateTime();
        this.createdBy = taskEntity.getCreatedBy();
        this.assignedTo = taskEntity.getAssignedTo();
        this.completed = taskEntity.isCompleted();
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

}
