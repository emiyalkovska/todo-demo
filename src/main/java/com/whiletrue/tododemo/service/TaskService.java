package com.whiletrue.tododemo.service;

import com.whiletrue.tododemo.dto.Task;
import com.whiletrue.tododemo.dto.TaskResponse;

public interface TaskService {

    TaskResponse createTask(Task task);

}
