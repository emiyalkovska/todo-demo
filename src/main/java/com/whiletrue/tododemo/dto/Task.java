package com.whiletrue.tododemo.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Task {

    private String name;
    private String description;
    private LocalDateTime dueDateTime;
    private String createdBy;
    private String assignedTo;
    private boolean completed;

    public Task(String name, String description, LocalDateTime dueDateTime, String createdBy, String assignedTo, boolean completed) {
        this.name = name;
        this.description = description;
        this.dueDateTime = dueDateTime;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.completed = completed;
    }

}
