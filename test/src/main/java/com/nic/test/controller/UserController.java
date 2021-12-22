package com.nic.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nic.test.entity.User;
import com.nic.test.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	@RequestMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping
	@RequestMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@GetMapping
	@RequestMapping("/userbyname/{name}")
	public ResponseEntity<Object> getUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}
	
	@PostMapping
	@RequestMapping("/adduser")	
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping
	@RequestMapping("/updateuser")
	public String updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping
	@RequestMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

}
