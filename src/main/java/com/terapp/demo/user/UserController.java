package com.terapp.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/api/users/add")
	public void save(@RequestBody User user) {
		userService.save(user);
	}
	
	@RequestMapping("/api/users/list")
	public List<User> list(){
		return userService.list();
	}

}
