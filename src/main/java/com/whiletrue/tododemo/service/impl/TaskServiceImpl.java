package com.whiletrue.tododemo.service.impl;

import com.whiletrue.tododemo.dto.TaskRequest;
import com.whiletrue.tododemo.dto.TaskResponse;
import com.whiletrue.tododemo.entity.Task;
import com.whiletrue.tododemo.repository.TaskRepository;
import com.whiletrue.tododemo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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

        return tasks.stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse getTask(Long taskId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with id=" + taskId + " not found!"));

        return new TaskResponse(task);
    }

    @Override
    public TaskResponse updateTask(Long taskId, TaskRequest taskRequest) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with id=" + taskId + " not found!"));

        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setDueDateTime(taskRequest.getDueDateTime());
        task.setAssignedTo(taskRequest.getAssignedTo());
        task.setCompleted(taskRequest.isCompleted());

        taskRepository.save(task);

        return new TaskResponse(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with id=" + taskId + " not found!"));

        taskRepository.deleteById(task.getId());
    }

}
