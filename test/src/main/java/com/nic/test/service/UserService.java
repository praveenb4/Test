package com.nic.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nic.test.entity.User;
import com.nic.test.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getUsers() {		
		List<User> users = userRepo.findAll();		
		return users;
	}
	
	public User getUser(int id) {		
		User user = userRepo.findById(id).get();		
		return user;
	}
	
	public String addUser(User user) {		
		userRepo.save(user);
		return "User Added Successfully";
	}
	
	public String updateUser(User user) {		
		userRepo.save(user);
		return "User Updated Successfully";
	}
	
	public String deleteUser(int id) {		
		userRepo.deleteById(id);;
		return "User Deleted Successfully";
	}	
	
	public ResponseEntity<Object> getUserByName(String name) {		
		User user = userRepo.findByUsername(name);		
		if(user == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User doesn't exists ");
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

}
