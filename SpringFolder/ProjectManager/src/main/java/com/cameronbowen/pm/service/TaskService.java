package com.cameronbowen.pm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronbowen.pm.models.Task;
import com.cameronbowen.pm.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepo;
	
	public List<Task> allTasks() {
		return taskRepo.findAll();
	}
	
	public List<Task> projectTasks(Long projectId) {
		return taskRepo.findByProjectIdIs(projectId);
	}
	
	public Task addTask(Task task) {
		return taskRepo.save(task);
	}
	
	public void deleteTask(Task task) {
		taskRepo.delete(task);
	}
}
