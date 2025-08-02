package com.railse.workforcemgmt.service;

import com.railse.workforcemgmt.dto.CreateTaskRequest;
import com.railse.workforcemgmt.dto.TaskDto;
import com.railse.workforcemgmt.model.Task;
import com.railse.workforcemgmt.model.enums.Priority;
import com.railse.workforcemgmt.model.enums.Status;
import com.railse.workforcemgmt.repository.TaskRepository;
import com.railse.workforcemgmt.utils.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService {
	private final TaskRepository repository = new TaskRepository();

	public TaskDto createTask(CreateTaskRequest request) {
		Task task = Mapper.toTask(request);
		task.setActivityLogs(new ArrayList<>(List.of("Task created")));
		repository.save(task);
		return Mapper.toDto(task);
	}

	public void updatePriority(String taskId, Priority priority) {
		Task task = repository.findById(taskId);
		if (task != null) {
			task.setPriority(priority);
			task.getActivityLogs().add("Priority updated to " + priority);
		}
	}

	public void addComment(String taskId, String comment) {
		Task task = repository.findById(taskId);
		if (task != null) {
			task.getComments().add(comment);
			task.getActivityLogs().add("Comment added: " + comment);
		}
	}

	public List<TaskDto> getTasksByPriority(Priority priority) {
		return repository.findAll().stream()
				.filter(t -> t.getPriority() == priority && t.getStatus() != Status.CANCELLED).map(Mapper::toDto)
				.collect(Collectors.toList());
	}

	public List<TaskDto> getTasksByDateRange(LocalDate from, LocalDate to) {
		return repository.findAll().stream().filter(t -> t.getStatus() != Status.CANCELLED)
				.filter(t -> (t.getStartDate().isAfter(from.minusDays(1)) && t.getStartDate().isBefore(to.plusDays(1)))
						|| (t.getStartDate().isBefore(from) && t.getStatus() == Status.ACTIVE))
				.map(Mapper::toDto).collect(Collectors.toList());
	}

	public TaskDto getTaskById(String id) {
		Task task = repository.findById(id);
		return Mapper.toDto(task);
	}
}