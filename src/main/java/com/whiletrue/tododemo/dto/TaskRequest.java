package com.whiletrue.tododemo.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class TaskRequest {

    private String name;
    private String description;
    private Instant dueDateTime;
    private boolean completed;

    public TaskRequest(String name, String description, Instant dueDateTime, boolean completed) {
        this.name = name;
        this.description = description;
        this.dueDateTime = dueDateTime;
        this.completed = completed;
    }
}
