package com.railse.workforcemgmt.utils;

import com.railse.workforcemgmt.dto.CreateTaskRequest;
import com.railse.workforcemgmt.dto.TaskDto;
import com.railse.workforcemgmt.model.Task;

public class Mapper {
	public static Task toTask(CreateTaskRequest req) {
		Task task = new Task();
		task.setTitle(req.getTitle());
		task.setStartDate(req.getStartDate());
		task.setDueDate(req.getDueDate());
		task.setPriority(req.getPriority());
		task.setAssignedTo(req.getAssignedTo());
		task.setStatus(com.railse.workforcemgmt.model.enums.Status.ACTIVE);
		return task;
	}

	public static TaskDto toDto(Task task) {
		TaskDto dto = new TaskDto();
		dto.setId(task.getId());
		dto.setTitle(task.getTitle());
		dto.setStartDate(task.getStartDate());
		dto.setDueDate(task.getDueDate());
		dto.setPriority(task.getPriority());
		dto.setStatus(task.getStatus());
		dto.setAssignedTo(task.getAssignedTo());
		dto.setComments(task.getComments());
		dto.setActivityLogs(task.getActivityLogs());
		return dto;
	}
}
