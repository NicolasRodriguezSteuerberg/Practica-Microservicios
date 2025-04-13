package com.nsteuerberg.microservices.students.service.implementations;

import com.nsteuerberg.microservices.students.persistance.entity.StudentEntity;
import com.nsteuerberg.microservices.students.persistance.repository.IStudentRepository;
import com.nsteuerberg.microservices.students.presentation.dto.request.StudentRequest;
import com.nsteuerberg.microservices.students.presentation.dto.response.StudentResponse;
import com.nsteuerberg.microservices.students.service.interfaces.IStudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveStudent(StudentRequest studentRequest) {
        StudentEntity student = StudentEntity.builder()
                .name(studentRequest.name())
                .lastName(studentRequest.lastName())
                .email(studentRequest.email())
                .courseId(studentRequest.courseId())
                .build();
        studentRepository.save(student);
    }

    @Override
    public List<StudentResponse> findAll() {
        List<StudentResponse> studentResponses = new ArrayList<>();
        studentRepository.findAll().forEach(
                studentEntity -> studentResponses.add(
                        new StudentResponse(
                                studentEntity.getName(),
                                studentEntity.getLastName(),
                                studentEntity.getEmail(),
                                studentEntity.getCourseId()
                        )
                )
        );

        return studentResponses;
    }

    @Override
    public StudentResponse findStudentById(Long id) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(""));
        return new StudentResponse(student.getName(), student.getLastName(), student.getEmail(), student.getCourseId());
    }

    @Override
    public List<StudentResponse> findCourseStudents(Long courseId) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        studentRepository.findAllByCourseId(courseId).forEach(studentEntity ->
                studentResponses.add(
                        new StudentResponse(
                                studentEntity.getName(),
                                studentEntity.getLastName(),
                                studentEntity.getEmail(),
                                studentEntity.getCourseId()
                        )
                )
        );

        return studentResponses;
    }
}
