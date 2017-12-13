package com.example.mapper;


	import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.example.entity.UserEntity;


public interface UserMapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);

}
