package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
	public List<UserCourse> getAllUsers() {
		List<UserCourse> userList = userRepository.findAll();
				return userList;
	}	
	
	@GetMapping("/login/{email}/{password}")
	public LoggedIn authenticate(@PathVariable(value = "email")
		String email, @PathVariable(value="password") String password) {
//		UserCourse authenticateUser = userRepository.findByUser(login_id);
		
		UserCourse authenticateUser = userRepository.findByEmailAndPassword(email, password);
		System.out.println(email + " " + password);
		if(authenticateUser != null) {
			
			return new LoggedIn("granted");
					
		}
		return new LoggedIn("denied");
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserCourse> registerUser(@RequestBody UserCourse user) {
		
		String validateUser = user.getEmail();
		Integer validatePhone = user.getPhone();
		UserCourse existingUser = userRepository.findByEmail(validateUser);
		UserCourse existingUserPhone = userRepository.findByPhone(validatePhone);

		if (existingUser != null || existingUserPhone != null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} 
		UserCourse savingNewUser = userRepository.save(user);
		return new ResponseEntity<>(savingNewUser, HttpStatus.OK);
		
	}
}
