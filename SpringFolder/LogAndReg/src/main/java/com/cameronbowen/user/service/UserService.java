package com.cameronbowen.user.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cameronbowen.user.models.LoginUser;
import com.cameronbowen.user.models.User;
import com.cameronbowen.user.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	

    public User register(User newUser, BindingResult result) {
    	
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	
    	// Reject if email is taken (in database)
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Email is Already Taken!");
    	}
    	
    	// Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("password", "Matches", "Password Doesn't Match!");
    	}
    	
    	// Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	// Hashed Password and save to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    	
    }
    
    
    
    public User login(LoginUser newLogin, BindingResult result) {
    	
    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
    	
    	// Find User and Reject if not present
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User Not Found!");
    		return null;
    	}
    	// User exists, retrieve from DB
    	User user = potentialUser.get();
    	
    	// Reject if BCrypt password match fails
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
    
}
