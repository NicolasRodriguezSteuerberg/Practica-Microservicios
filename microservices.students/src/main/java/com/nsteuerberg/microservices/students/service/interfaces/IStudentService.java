package com.nsteuerberg.microservices.students.service.interfaces;

import com.nsteuerberg.microservices.students.presentation.dto.request.StudentRequest;
import com.nsteuerberg.microservices.students.presentation.dto.response.StudentResponse;

import java.util.List;

public interface IStudentService {

    void saveStudent(StudentRequest studentRequest);

    List<StudentResponse> findAll();

    StudentResponse findStudentById(Long id);

    List<StudentResponse> findCourseStudents(Long courseId);
}
