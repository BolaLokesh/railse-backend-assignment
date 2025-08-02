package com.railse.workforcemgmt.controller;

import com.railse.workforcemgmt.dto.CreateTaskRequest;
import com.railse.workforcemgmt.dto.TaskDto;
import com.railse.workforcemgmt.model.enums.Priority;
import com.railse.workforcemgmt.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping
	public TaskDto createTask(@RequestBody CreateTaskRequest request) {
		return taskService.createTask(request);
	}

	@PutMapping("/{id}/priority")
	public void updatePriority(@PathVariable String id, @RequestParam Priority priority) {
		taskService.updatePriority(id, priority);
	}

	@PostMapping("/{id}/comment")
	public void addComment(@PathVariable String id, @RequestParam String comment) {
		taskService.addComment(id, comment);
	}

	@GetMapping("/priority/{priority}")
	public List<TaskDto> getTasksByPriority(@PathVariable Priority priority) {
		return taskService.getTasksByPriority(priority);
	}

	@GetMapping
	public List<TaskDto> getTasksByDateRange(@RequestParam LocalDate from, @RequestParam LocalDate to) {
		return taskService.getTasksByDateRange(from, to);
	}

	@GetMapping("/{id}")
	public TaskDto getTaskById(@PathVariable String id) {
		return taskService.getTaskById(id);
	}
}
