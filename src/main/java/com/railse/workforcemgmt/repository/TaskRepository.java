package com.railse.workforcemgmt.repository;

import com.railse.workforcemgmt.model.Task;

import java.util.*;

public class TaskRepository {
	private final Map<String, Task> tasks = new HashMap<>();

	public void save(Task task) {
		if (task.getId() == null)
			task.setId(UUID.randomUUID().toString());
		tasks.put(task.getId(), task);
	}

	public Task findById(String id) {
		return tasks.get(id);
	}

	public List<Task> findAll() {
		return new ArrayList<>(tasks.values());
	}
}