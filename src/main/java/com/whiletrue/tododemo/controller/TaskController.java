package com.whiletrue.tododemo.controller;

import com.whiletrue.tododemo.dto.Task;
import com.whiletrue.tododemo.dto.TaskResponse;
import com.whiletrue.tododemo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody Task task) {
        TaskResponse response = taskService.createTask(task);
        return response;
    }

    @GetMapping
    public List<TaskResponse> getTasks() {
        // TODO create logic for retrieving tasks from DB
        List<TaskResponse> tasks = new ArrayList<>();
        return tasks;
    }

    @GetMapping("/{taskId}")
    public TaskResponse getTask(@PathVariable("taskId") Long taskId) {
        // TODO create logic for retrieving task from DB
        return null;
    }

    @PutMapping("/{taskId}")
    public TaskResponse updateTask(@PathVariable("taskId") Long taskId,
                                   @RequestBody Task task) {
        // TODO create logic for updating in DB
        return null;
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        // TODO create logic for deleting from DB
    }
}
