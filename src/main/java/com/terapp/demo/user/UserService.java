package com.terapp.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;		
	
	PasswordEncoder passwordEncoder;
	
	public UserService() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public void save(User user) {		
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));			
		userRepository.save(user);
		
	}
	public List<User> list(){
		return userRepository.findAll();
	}
}
