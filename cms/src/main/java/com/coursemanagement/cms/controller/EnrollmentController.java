package com.coursemanagement.cms.controller;

import com.coursemanagement.cms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping("/{courseId}")
    public String enroll(@PathVariable Long courseId) {
        return enrollmentService.enrollInCourse(courseId);
    }
}
