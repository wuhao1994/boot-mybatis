package com.example.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserEntity;
import com.example.service.UserService;


@RestController
public class HelloController {
	@RequestMapping("/test")
	public String Hello(){
		return "hello";
	}
	
}
