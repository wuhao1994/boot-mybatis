package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService {
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);
}
