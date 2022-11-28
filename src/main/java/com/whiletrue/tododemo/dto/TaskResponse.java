package com.whiletrue.tododemo.dto;

import com.whiletrue.tododemo.entity.Task;
import lombok.Data;

import java.time.Instant;

@Data
public class TaskResponse {

    private Long id;
    private String name;
    private String description;
    private Instant dueDateTime;
    private boolean completed;

    public TaskResponse(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.dueDateTime = task.getDueDateTime();
        this.completed = task.isCompleted();

    }
}
