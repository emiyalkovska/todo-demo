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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date_time")
    private Instant dueDateTime;

    @Column(name = "completed")
    private boolean completed;

    public Task(TaskRequest taskRequest, User user) {
        this.name = taskRequest.getName();
        this.description = taskRequest.getDescription();
        this.dueDateTime = taskRequest.getDueDateTime();
        this.completed = taskRequest.isCompleted();
        this.user = user;
    }

}
