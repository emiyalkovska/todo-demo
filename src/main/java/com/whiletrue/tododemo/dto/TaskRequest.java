package com.whiletrue.tododemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class TaskRequest {

    private String name;
    private String description;
    private Instant dueDateTime;
    private boolean completed;

}
