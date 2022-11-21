package com.whiletrue.tododemo.service.impl;

import com.whiletrue.tododemo.dto.TaskRequest;
import com.whiletrue.tododemo.dto.TaskResponse;
import com.whiletrue.tododemo.entity.Task;
import com.whiletrue.tododemo.repository.TaskRepository;
import com.whiletrue.tododemo.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {

        Task task = new Task();
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setDueDateTime(taskRequest.getDueDateTime());
        task.setCreatedBy(taskRequest.getCreatedBy());
        task.setAssignedTo(taskRequest.getAssignedTo());
        task.setCompleted(taskRequest.isCompleted());

        taskRepository.save(task);
        return new TaskResponse(task);
    }
}
