package com.coursemanagement.cms.repository;

import com.coursemanagement.cms.entity.Course;
import com.coursemanagement.cms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructor(User instructor);
}
