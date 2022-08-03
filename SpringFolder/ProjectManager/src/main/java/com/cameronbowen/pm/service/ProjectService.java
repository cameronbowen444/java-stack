package com.cameronbowen.pm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronbowen.pm.models.Project;
import com.cameronbowen.pm.models.User;
import com.cameronbowen.pm.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepo;
	
	public List<Project> allProjects() {
		return projectRepo.findAll();
	}
	
	public Project findById(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}
		else {
			return null;
		}
	}
	
	public Project create(Project project) {
		return projectRepo.save(project);
	}
	
	public Project update(Project project) {
		return projectRepo.save(project);
	}
	
	public void delete(Project project) {
		projectRepo.delete(project);
	}
	
	public List<Project> getAssignedUsers(User users) {
		return projectRepo.findAllByUsers(users);
	}
	public List<Project> getUnAssignedUsers(User users) {
		return projectRepo.findByUsersNotContains(users);
	}
}
