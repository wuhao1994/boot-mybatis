package com.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.entity.UserEntity;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
@Service
public class UserSerivceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		return userMapper.getAll();
	}

	@Override
	public UserEntity getOne(Long id) {
		// TODO Auto-generated method stub
		return userMapper.getOne(id);
	}

	@Override
	public void insert(UserEntity user) {
		userMapper.insert(user);
	}

	@Override
	public void update(UserEntity user) {
		userMapper.update(user);
	}

	@Override
	public void delete(Long id) {
		userMapper.delete(id);
	}

}
