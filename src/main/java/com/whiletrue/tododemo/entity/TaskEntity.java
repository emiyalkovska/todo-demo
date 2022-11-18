package com.whiletrue.tododemo.entity;

import com.whiletrue.tododemo.dto.Task;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "task")
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public TaskEntity(Long id, Task task) {
        this.id = id;
        this.name = task.getName();
        this.description = task.getDescription();
        this.dueDateTime = task.getDueDateTime();
        this.createdBy = task.getCreatedBy();
        this.assignedTo = task.getAssignedTo();
        this.completed = task.isCompleted();
    }
}
