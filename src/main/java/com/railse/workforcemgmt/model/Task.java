package com.railse.workforcemgmt.model;

import com.railse.workforcemgmt.model.enums.Priority;
import com.railse.workforcemgmt.model.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Task {
	private String id;
	private String title;
	private Status status;
	private LocalDate startDate;
	private LocalDate dueDate;
	private Priority priority;
	private Staff assignedTo;
	private List<String> comments = new ArrayList<>();
	private List<String> activityLogs = new ArrayList<>();
}
