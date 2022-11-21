package com.whiletrue.tododemo.entity;

import com.whiletrue.tododemo.dto.TaskRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "task")
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date_time")
    private Instant dueDateTime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "assigned_to")
    private String assignedTo;

    @Column(name = "completed")
    private boolean completed;

    public Task(Long id, TaskRequest taskRequest) {
        this.id = id;
        this.name = taskRequest.getName();
        this.description = taskRequest.getDescription();
        this.dueDateTime = taskRequest.getDueDateTime();
        this.createdBy = taskRequest.getCreatedBy();
        this.assignedTo = taskRequest.getAssignedTo();
        this.completed = taskRequest.isCompleted();
    }
}
