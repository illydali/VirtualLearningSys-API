package com.demo.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.UserCourse;
import com.demo.model.LoggedIn;
import com.demo.repository.UserCourseRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class UserCourseController {

	@Autowired
	private UserCourseRepository userRepository;
	
	@GetMapping("/users")
	public List getAllUsers() {
		List<UserCourse> userList = userRepository.findAll();
				return userList;
	}
	
//	@GetMapping("/login/{login_id}/{password}")
//	public String authenticate(@PathVariable(value = "login_id")
//		String login_id, @PathVariable(value="password") String password) {
//		UserCourse authenticateUser = userRepository.findByUser(login_id);
//		
//		if(authenticateUser != null) {
//			return "yes";
//		}
//		return "no";
//	}
//		
	
	@GetMapping("/login/{login_id}/{password}")
	public LoggedIn authenticate(@PathVariable(value = "login_id")
		String login_id, @PathVariable(value="password") String password) {
//		UserCourse authenticateUser = userRepository.findByUser(login_id);
		
		UserCourse authenticateUser = userRepository.findByUserAndPassword(login_id, password);
		System.out.println(login_id + " " + password);
		if(authenticateUser != null) {
			
			return new LoggedIn("granted");
					
		}
		return new LoggedIn("denied");
	}
	
	@PostMapping("/register")
	public UserCourse registerUser(@RequestBody UserCourse user) {
		UserCourse savedUser = userRepository.save(user);
		System.err.println(user);
		return savedUser;
	}
	
//	@PostMapping("/login/{login_id}")
//	public User getUser(@RequestBody(value="login_id") String user) {
//		User existingUser = userRepository.findByUser(user);
//		System.err.println("Successfully found" + user);
//		
//		return existingUser;
//	}
}
