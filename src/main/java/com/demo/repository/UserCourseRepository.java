package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.UserCourse;

public interface UserCourseRepository extends JpaRepository<UserCourse, Integer> {

	UserCourse findByUserAndPassword(String user, String password);
//	List<UserCourse> findByUserPassword(String user, String password);
	UserCourse findByUser(String userName);
}
