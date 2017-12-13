package com.example.service;

import java.util.List;


import com.example.entity.UserEntity;

public interface UserService {
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);
}
