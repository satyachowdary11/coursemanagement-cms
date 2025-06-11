package com.coursemanagement.cms.service;

import com.coursemanagement.cms.entity.Course;
import com.coursemanagement.cms.entity.Enrollment;
import com.coursemanagement.cms.entity.User;
import com.coursemanagement.cms.repository.CourseRepository;
import com.coursemanagement.cms.repository.EnrollmentRepository;
import com.coursemanagement.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    public String enrollInCourse(Long courseId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User student = userRepository.findByUsername(username).orElseThrow();

        Course course = courseRepository.findById(courseId).orElseThrow();

        boolean alreadyEnrolled = enrollmentRepository.findByStudentAndCourse(student, course).isPresent();
        if (alreadyEnrolled) {
            return "Already enrolled in this course.";
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollmentRepository.save(enrollment);

        return "Enrolled successfully!";
    }
}
