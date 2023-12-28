package br.com.danielferreira.ctrlab.modules.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielferreira.ctrlab.modules.course.domain.Course;

public interface CourseRepository extends JpaRepository<Course, String>{
    
}
