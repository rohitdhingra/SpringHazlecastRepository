package com.example.cache.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cache.api.model.User;
import com.example.cache.api.service.UserService;

@RestController
@RequestMapping("/cache-api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		return userService.getUsers();
	}
	
	@GetMapping("/getUserById/{id}")
	public User getUser(@PathVariable int id)
	{
		Optional<User> userVal = userService.getUser(id);
		if(userVal.isPresent())
			return userVal.get();
		return null;
	}
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id)
	{
		return userService.delete(id);
	}
	
	@PostMapping(value = "/insertUser",consumes = "application/json")
	public String deleteUser(@RequestBody User user)
	{
		return userService.insertUser(user);
	}
}
