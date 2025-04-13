package com.nsteuerberg.microservices.students.presentation.controller;

import com.nsteuerberg.microservices.students.presentation.dto.request.StudentRequest;
import com.nsteuerberg.microservices.students.presentation.dto.response.StudentResponse;
import com.nsteuerberg.microservices.students.service.implementations.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getStudentsInCourse(@PathVariable Long id) {
        return studentService.findCourseStudents(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveStudent(@RequestBody StudentRequest studentRequest) {
        studentService.saveStudent(studentRequest);
    }

}
