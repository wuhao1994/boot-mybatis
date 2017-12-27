package com.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.entity.UserExample;
import com.example.mapper.test1.UserMapper;
import com.example.service.UserService;
@Service
public class UserSerivceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(new UserExample());
	}

	@Override
	public User getOne(Long id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insert(User user) {
		userMapper.insert(user);
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public void delete(Long id) {
		userMapper.deleteByPrimaryKey(id);
	}

}
