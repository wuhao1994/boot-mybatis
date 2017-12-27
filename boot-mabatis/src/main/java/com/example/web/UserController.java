package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.entity.UserExample;
import com.example.mapper.test1.UserMapper;
import com.example.mapper.test2.UserMapper2;

@RestController
public class UserController {

    @Autowired
    private UserMapper user1Mapper;

	@Autowired
	private UserMapper2 user2Mapper;
	
	@RequestMapping("/getUsers")
	public List<User> getUsers() {
		List<User> users=user1Mapper.selectByExample(new UserExample());
		return users;
	}
	
    @RequestMapping("/getUser")
    public User getUser(Long id) {
    	User user=user2Mapper.selectByPrimaryKey(id);
        return user;
    }
    @RequestMapping("/add1")
    public void save1(User user) {
        user2Mapper.insert(user);
    }
    
    @RequestMapping("/add")
    public void save(User user) {
        user1Mapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(User user) {
        user2Mapper.updateByPrimaryKey(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.deleteByPrimaryKey(id);
    }
    
    
}