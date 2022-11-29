package com.whiletrue.tododemo.service.impl;

import com.whiletrue.tododemo.dto.TaskRequest;
import com.whiletrue.tododemo.dto.TaskResponse;
import com.whiletrue.tododemo.entity.Task;
import com.whiletrue.tododemo.entity.User;
import com.whiletrue.tododemo.repository.TaskRepository;
import com.whiletrue.tododemo.repository.UserRepository;
import com.whiletrue.tododemo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository,
                           UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {

        User user = getAuthorizedUser();

        Task task = new Task(taskRequest, user);

        taskRepository.save(task);
        return new TaskResponse(task);
    }

    @Override
    public List<TaskResponse> getTasks() {

        User user = getAuthorizedUser();

        List<Task> tasks = user.getTasks();

        return tasks.stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse getTask(Long taskId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Task with id=%d not found!", taskId)));

        return new TaskResponse(task);
    }

    @Override
    public TaskResponse updateTask(Long taskId, TaskRequest taskRequest) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Task with id=%d not found!", taskId)));

        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setDueDateTime(taskRequest.getDueDateTime());
        task.setCompleted(taskRequest.isCompleted());

        taskRepository.save(task);

        return new TaskResponse(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Task with id=%d not found!", taskId)));

        taskRepository.deleteById(task.getId());
    }

    private User getAuthorizedUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return userRepository.findByUsername(username);
    }

}
