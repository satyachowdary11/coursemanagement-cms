package com.coursemanagement.cms.controller;

import com.coursemanagement.cms.dto.CourseDto;
import com.coursemanagement.cms.entity.Course;
import com.coursemanagement.cms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @PostMapping
    public String createCourse(@RequestBody CourseDto dto) {
        return courseService.createCourse(dto);
    }

    @PreAuthorize("hasAnyRole('STUDENT', 'INSTRUCTOR', 'ADMIN')")
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
}
