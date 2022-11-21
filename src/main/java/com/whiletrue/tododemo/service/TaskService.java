package com.whiletrue.tododemo.service;

import com.whiletrue.tododemo.dto.TaskRequest;
import com.whiletrue.tododemo.dto.TaskResponse;

public interface TaskService {

    TaskResponse createTask(TaskRequest taskRequest);

}
