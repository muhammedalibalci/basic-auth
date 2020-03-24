package com.terapp.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terapp.demo.configuration.MyUserDetails;
import com.terapp.demo.user.User;
import com.terapp.demo.user.UserRepository;

@RestController
public class AuthController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/api/auth")
	ResponseEntity<?> handleAuthentication() {		
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		userDetails.getUsername();
		String username = userDetails.getUsername();
		User inDB = userRepository.findByName(username);
		return ResponseEntity.ok(inDB);
	}
	
}