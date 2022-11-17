package com.whiletrue.tododemo.dto;

import java.time.LocalDateTime;

public class TaskResponse {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime dueDateTime;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
