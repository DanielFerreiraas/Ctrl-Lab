package br.com.danielferreira.ctrlab.modules.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.danielferreira.ctrlab.exception.BadRequestException;
import br.com.danielferreira.ctrlab.modules.course.repository.CourseRepository;
import br.com.danielferreira.ctrlab.modules.course.domain.Course;

@Service
public class CourseService {

  private CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public Course createCourse(Course course) {
    return courseRepository.save(course);
  }

  public List<Course> listCourses() {
    Sort sort = Sort.by(Direction.ASC, "name");
    return courseRepository.findAll(sort);
  }

  public Optional<Course> getById(String id) {
    return courseRepository.findById(id);
  }

  public Course updateCourse(String id, Course course) {
    courseRepository.findById(id).ifPresentOrElse((existingCourse) -> {
      course.setId(id);
      courseRepository.save(course);
    }, () -> {
      throw new BadRequestException("Course %d não existe! ".formatted(id));
    });

    return course;
  }

  public Course deleteCourse(String id) {
    courseRepository.findById(id).ifPresentOrElse((existingCourse) -> courseRepository.delete(existingCourse), () -> {
      throw new BadRequestException("Course %d não existe! ".formatted(id));
    });
    return null;
  }

}
