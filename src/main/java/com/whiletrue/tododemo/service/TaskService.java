package com.whiletrue.tododemo.service;

import com.whiletrue.tododemo.dto.TaskRequest;
import com.whiletrue.tododemo.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskRequest taskRequest);

    List<TaskResponse> getTasks();

    TaskResponse getTask(Long taskId);

    TaskResponse updateTask(Long taskId, TaskRequest taskRequest);
}
