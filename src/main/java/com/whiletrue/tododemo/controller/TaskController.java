package com.whiletrue.tododemo.controller;

import com.whiletrue.tododemo.dto.TaskRequest;
import com.whiletrue.tododemo.dto.TaskResponse;
import com.whiletrue.tododemo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
        TaskResponse response = taskService.createTask(taskRequest);
        return response;
    }

    @GetMapping
    public List<TaskResponse> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{taskId}")
    public TaskResponse getTask(@PathVariable("taskId") Long taskId) {
        // TODO create logic for retrieving task from DB
        return null;
    }

    @PutMapping("/{taskId}")
    public TaskResponse updateTask(@PathVariable("taskId") Long taskId,
                                   @RequestBody TaskRequest taskRequest) {
        // TODO create logic for updating in DB
        return null;
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        // TODO create logic for deleting from DB
    }
}
