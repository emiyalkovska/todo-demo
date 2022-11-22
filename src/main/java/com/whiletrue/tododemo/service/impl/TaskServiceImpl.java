package com.whiletrue.tododemo.service.impl;

import com.whiletrue.tododemo.dto.TaskRequest;
import com.whiletrue.tododemo.dto.TaskResponse;
import com.whiletrue.tododemo.entity.Task;
import com.whiletrue.tododemo.exception.TaskNotFoundException;
import com.whiletrue.tododemo.repository.TaskRepository;
import com.whiletrue.tododemo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<TaskResponse> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponse> taskResponses = tasks.stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());

        return taskResponses;
    }

    @Override
    public TaskResponse getTask(Long taskId) {

        Optional<Task> task = taskRepository.findById(taskId);

        if (task.isPresent()) {
            TaskResponse taskResponse = new TaskResponse(task.get());
            return taskResponse;
        } else {
            throw new TaskNotFoundException(taskId);
        }
    }

    @Override
    public TaskResponse updateTask(Long taskId, TaskRequest taskRequest) {

        //first check whether task with given id exist in DB OR not
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if (taskOptional.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        Task task = taskOptional.get();
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setDueDateTime(taskRequest.getDueDateTime());
        task.setAssignedTo(taskRequest.getAssignedTo());
        task.setCompleted(taskRequest.isCompleted());

        taskRepository.save(task);

        TaskResponse updatedTask = new TaskResponse(task);

        return updatedTask;
    }

    @Override
    public void deleteTask(Long taskId) {
        //first check whether task with given id exist in DB OR not
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if (taskOptional.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        taskRepository.deleteById(taskId);
    }

}
