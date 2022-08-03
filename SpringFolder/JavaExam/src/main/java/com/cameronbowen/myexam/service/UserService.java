package com.cameronbowen.myexam.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cameronbowen.myexam.models.LoginUser;
import com.cameronbowen.myexam.models.User;
import com.cameronbowen.myexam.repositories.UserRepository;

@Service
public class UserService {
	

	@Autowired
	private UserRepository userRepo;
	
	
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

	public User findById(Long id) {
		Optional<User> potentialUser = userRepo.findById(id);
		if(potentialUser.isPresent()) {
			return potentialUser.get();
		}
		return null;
	}
	
	public User findByEmail(String email) {
		Optional<User> potentialUser = userRepo.findByEmail(email);
		if(potentialUser.isPresent()) {
			return potentialUser.get();
		}
		return null;
	}
	
	public User create(User user) {
		return userRepo.save(user);
	}
	
	public User update(User user) {
		return userRepo.save(user);
	}
	
	
}
