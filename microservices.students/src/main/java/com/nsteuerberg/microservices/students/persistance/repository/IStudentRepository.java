package com.nsteuerberg.microservices.students.persistance.repository;

import com.nsteuerberg.microservices.students.persistance.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends CrudRepository<StudentEntity, Long> {
    List<StudentEntity> findAllByCourseId(Long courseId);
}
