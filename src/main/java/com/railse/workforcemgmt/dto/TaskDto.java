package com.railse.workforcemgmt.dto;

import com.railse.workforcemgmt.model.Staff;
import com.railse.workforcemgmt.model.enums.Priority;
import com.railse.workforcemgmt.model.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TaskDto {
	private String id;
	private String title;
	private Status status;
	private LocalDate startDate;
	private LocalDate dueDate;
	private Priority priority;
	private Staff assignedTo;
	private List<String> comments;
	private List<String> activityLogs;
}