package com.whiletrue.tododemo.dto;

import java.time.LocalDateTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
