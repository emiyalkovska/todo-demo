package com.whiletrue.tododemo.service.impl;

import com.whiletrue.tododemo.dto.Task;
import com.whiletrue.tododemo.dto.TaskResponse;
import com.whiletrue.tododemo.entity.TaskEntity;
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
    public TaskResponse createTask(Task task) {

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setName(task.getName());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setDueDateTime(task.getDueDateTime());
        taskEntity.setCreatedBy(task.getCreatedBy());
        taskEntity.setAssignedTo(task.getAssignedTo());
        taskEntity.setCompleted(task.isCompleted());

        taskRepository.save(taskEntity);
        return new TaskResponse(taskEntity);
    }
}
