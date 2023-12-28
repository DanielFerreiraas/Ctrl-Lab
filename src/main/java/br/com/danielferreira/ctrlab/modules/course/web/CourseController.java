package br.com.danielferreira.ctrlab.modules.course.web;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielferreira.ctrlab.modules.course.service.CourseService;
import br.com.danielferreira.ctrlab.modules.course.domain.Course;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {
    
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
  ResponseEntity<Course> create(@Valid @RequestBody Course course) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(courseService.createCourse(course));
  }

  @GetMapping
  List<Course> list() {
    return courseService.listLaboratories();
  }

  @GetMapping("{id}")
  Optional<Course> getById(@PathVariable String id) {
    return courseService.getById(id);
  }

  @PutMapping("{id}")
  ResponseEntity<Course> update(@PathVariable String id, @RequestBody Course course) {
    return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(courseService.updateCourse(id, course));
  }

  @DeleteMapping("{id}")
  ResponseEntity<Course> delete(@PathVariable String id) {
    return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(courseService.deleteCourse(id));
  }
}
