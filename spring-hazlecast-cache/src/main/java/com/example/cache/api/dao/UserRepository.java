package com.example.cache.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cache.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
