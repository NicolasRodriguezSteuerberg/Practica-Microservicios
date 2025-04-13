package com.nsteuerberg.microservices.courses.presentation.controller;

import com.nsteuerberg.microservices.courses.persistance.entity.CourseEntity;
import com.nsteuerberg.microservices.courses.presentation.dto.response.CourseStudentsResponse;
import com.nsteuerberg.microservices.courses.service.implementation.CourseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody CourseEntity courseEntity) {
        courseService.save(courseEntity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseEntity> findAll() {
        return courseService.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseEntity findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @GetMapping("{id}/students")
    @ResponseStatus(HttpStatus.OK)
    public CourseStudentsResponse findCourseByIdWithStudents(@PathVariable Long id) {
        return courseService.findCourseByIdWithStudents(id);
    }
}
