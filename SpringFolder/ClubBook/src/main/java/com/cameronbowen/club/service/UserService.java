package com.cameronbowen.club.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cameronbowen.club.models.LoginUser;
import com.cameronbowen.club.models.User;
import com.cameronbowen.club.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Account with this email already exisits!");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords Don't Match!");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		newUser =  userRepo.save(newUser);
		
		return newUser;
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "MissingEmail", "Email Not Found!");
			return null;
		}
		User user = potentialUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invaid Password");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		return user;
	}
	
	public User findByEmail(String email) {
		Optional<User> result = userRepo.findByEmail(email);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	public User findById(Long id) {
		Optional<User> result = userRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
}
