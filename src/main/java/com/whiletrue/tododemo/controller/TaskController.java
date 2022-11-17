package com.whiletrue.tododemo.controller;

import com.whiletrue.tododemo.dto.Task;
import com.whiletrue.tododemo.dto.TaskResponse;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private static Task hardcodedTask = new Task("test", "test description", Instant.now().plus(2, ChronoUnit.DAYS), "system", "elena", true);

    @PostMapping
    public TaskResponse createTask(@RequestBody Task task) {
        // TODO create logic for inserting into DB
        TaskResponse response = generateTaskResponse(task);
        return response;
    }

    @GetMapping
    public List<TaskResponse> getTasks() {
        // TODO create logic for retrieving tasks from DB
        List<TaskResponse> tasks = new ArrayList<>();
        tasks.add(generateTaskResponse(hardcodedTask));
        tasks.add(generateTaskResponse(hardcodedTask));
        return tasks;
    }

    @GetMapping("/{taskId}")
    public TaskResponse getTask(@PathVariable("taskId") Long taskId) {
        // TODO create logic for retrieving task from DB
        TaskResponse updatedTask = generateTaskResponse(hardcodedTask);
        return updatedTask;
    }

    @PutMapping("/{taskId}")
    public TaskResponse updateTask(@PathVariable("taskId") Long taskId,
                                   @RequestBody Task task) {
        // TODO create logic for updating in DB
        TaskResponse updatedTask = generateTaskResponse(task);
        return updatedTask;
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        // TODO create logic for deleting from DB
    }

    private TaskResponse generateTaskResponse(Task task) {
        Long id = 1L;
        return new TaskResponse(id, task);
    }

}
