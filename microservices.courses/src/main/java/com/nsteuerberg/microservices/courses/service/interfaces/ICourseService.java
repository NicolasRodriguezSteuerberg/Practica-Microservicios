package com.nsteuerberg.microservices.courses.service.interfaces;

import com.nsteuerberg.microservices.courses.persistance.entity.CourseEntity;
import com.nsteuerberg.microservices.courses.presentation.dto.response.CourseStudentsResponse;

import java.util.List;

public interface ICourseService {
    void save(CourseEntity courseEntity);

    List<CourseEntity> findAll();

    CourseEntity findById(Long id);

    CourseStudentsResponse findCourseByIdWithStudents(Long id);
}
