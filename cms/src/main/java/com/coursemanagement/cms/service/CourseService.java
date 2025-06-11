package com.coursemanagement.cms.service;

import com.coursemanagement.cms.dto.CourseDto;
import com.coursemanagement.cms.entity.Course;
import com.coursemanagement.cms.entity.User;
import com.coursemanagement.cms.repository.CourseRepository;
import com.coursemanagement.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public String createCourse(CourseDto dto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User instructor = userRepository.findByUsername(username).orElseThrow();

        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setInstructor(instructor);

        courseRepository.save(course);
        return "Course created successfully";
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
