package com.whiletrue.tododemo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException {

    private static final long taskId = 1L;
    private String taskName;
    private String fieldName;
    private Object fieldValue;

    public TaskNotFoundException(String taskName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s", taskName, fieldName, fieldValue));
        this.taskName = taskName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}