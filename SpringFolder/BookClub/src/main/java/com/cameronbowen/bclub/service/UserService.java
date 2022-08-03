package com.cameronbowen.bclub.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cameronbowen.bclub.models.LoginUser;
import com.cameronbowen.bclub.models.User;
import com.cameronbowen.bclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User register(@ModelAttribute("newUser") User newUser, BindingResult result) {
		
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Present", "Email is already taken! Try Another!");
		}
		
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "Match", "Passwords Do Not Match!");
		}
		
		if (result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	
	public User login(@ModelAttribute("newLogin") LoginUser newLogin, BindingResult result) {
		
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email Not Found!");
			return null;
		}
		
		User user = potentialUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invaild Password!");
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
}
