package com.example.cache.api.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.cache.api.dao.UserRepository;
import com.example.cache.api.model.User;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;

	@Cacheable(cacheNames = { "userCache" })
	public List<User> getUsers() {
		logger.info("Hit DB first Time in getUsers() method");
		return userRepository.findAll();
	}

	@Cacheable(value = "userCache", key = "#id", unless = "#result==null")
	public Optional<User> getUser(int id) {
		logger.info("Hit DB first Time in getUser() method");
		return userRepository.findById(id);
	}

	@CacheEvict(value = "userCache",allEntries = true)
	public String delete(int id) {
		userRepository.deleteById(id);
		return "User deleted by id:" + id;
	}
	@CacheEvict(value = "userCache",allEntries = true)
	@CachePut(value = "userCache")	
	public String insertUser(User user) {
		userRepository.save(user);
		return "User save by id:" + user.getId();
	}
}
