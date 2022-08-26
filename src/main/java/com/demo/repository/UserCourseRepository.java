package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.UserCourse;

public interface UserCourseRepository extends JpaRepository<UserCourse, Integer> {

	UserCourse findByEmailAndPassword(String email, String password);
	UserCourse findByEmail(String email);
	UserCourse findByPhone(Integer phone);
	// boolean emailExists(String email);
}
