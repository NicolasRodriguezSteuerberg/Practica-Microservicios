package com.nsteuerberg.microservices.courses.service.implementation;

import com.nsteuerberg.microservices.courses.persistance.entity.CourseEntity;
import com.nsteuerberg.microservices.courses.persistance.repository.ICourseRepository;
import com.nsteuerberg.microservices.courses.presentation.dto.response.CourseStudentsResponse;
import com.nsteuerberg.microservices.courses.presentation.dto.response.StudentResponse;
import com.nsteuerberg.microservices.courses.service.http.IStudentClient;
import com.nsteuerberg.microservices.courses.service.interfaces.ICourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository courseRepository;
    private final IStudentClient studentClient;

    public CourseServiceImpl(ICourseRepository courseRepository, IStudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;
    }

    @Override
    public void save(CourseEntity courseEntity) {
        courseRepository.save(courseEntity);
    }

    @Override
    public List<CourseEntity> findAll() {
        return (List<CourseEntity>) courseRepository.findAll();
    }

    @Override
    public CourseEntity findById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe ese id"));
    }

    @Override
    public CourseStudentsResponse findCourseByIdWithStudents(Long id) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe el curso con ese id"));
        List<StudentResponse> studentResponses = studentClient.findAllStudentById(id);

        return CourseStudentsResponse.builder()
                .courseName(courseEntity.getName())
                .teacher(courseEntity.getTeacher())
                .students(studentResponses)
                .build();

    }
}
