package com.coursemanagement.cms.repository;

import com.coursemanagement.cms.entity.Enrollment;
import com.coursemanagement.cms.entity.User;
import com.coursemanagement.cms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent(User student);
    Optional<Enrollment> findByStudentAndCourse(User student, Course course);
}
