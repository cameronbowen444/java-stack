package com.cameronbowen.pm.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cameronbowen.pm.models.LoginUser;
import com.cameronbowen.pm.models.Project;
import com.cameronbowen.pm.models.User;
import com.cameronbowen.pm.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that eail already exists!");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords do not match!");
		}
		if(result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail()); 
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email not found!");
			return null;
		}
		
		User user = potentialUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invaild Password");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		return user;
	}
	
	public List<User> allUsers() {
		return userRepo.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
	
	public User create(User user) {
		return userRepo.save(user);
	}
	
	public User update(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getAssignedProjects(Project project) {
		return userRepo.findAllByProjects(project);
	}
	
	public List<User> getUnAssignedProjects(Project project) {
		return userRepo.findAllByProjectsNotContains(project);
	}
	
}
