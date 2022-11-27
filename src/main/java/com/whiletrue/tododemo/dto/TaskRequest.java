package com.whiletrue.tododemo.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class TaskRequest {

    private String name;
    private String description;
    private Instant dueDateTime;
    private String createdBy;
    private String assignedTo;
    private boolean completed;

    public TaskRequest(String name, String description, Instant dueDateTime, String createdBy, String assignedTo, boolean completed) {
        this.name = name;
        this.description = description;
        this.dueDateTime = dueDateTime;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.completed = completed;
    }

}
