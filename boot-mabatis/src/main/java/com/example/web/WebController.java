package com.example.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.mapper.test1.UserMapper;
import com.example.mapper.test2.UserMapper2;
import com.example.service.UserService;



@Controller
@RequestMapping("/wuhao")
@EnableAutoConfiguration
public class WebController {
	@Resource
	private UserService userService;
	@Autowired
    private UserMapper user1Mapper;

	@Autowired
	private UserMapper2 user2Mapper;
	@RequestMapping("/hello")
	public String Hello(){
		return "hello";
	}
	
	 @RequestMapping("/list")
	    public String list(Model model) {
	        List<User> users=userService.getAll();
	        model.addAttribute("users", users);
	        return "user/list";
	    }

	    @RequestMapping("/toAdd")
	    public String toAdd() {
	        return "user/userAdd";
	    }

	    @RequestMapping("/add")
	    public String add(User user) {
	        userService.insert(user);
	        return "redirect:/list";
	    }

	    @RequestMapping("/toEdit")
	    public String toEdit(Model model,Long id) {
	    	User user=userService.getOne(id);
	        model.addAttribute("user", user);
	        return "user/userEdit";
	    }

	    @RequestMapping("/edit")
	    public String edit(User user) {
	        userService.update(user);
	        return "redirect:/list";
	    }


	    @RequestMapping("/delete")
	    public String delete(Long id) {
	        userService.delete(id);
	        return "redirect:/list";
	    }
	    
	    @RequestMapping("/baidumap")
	    public String baidumap() {
	        return "user/baidumap";
	    }
	    
	    
}
