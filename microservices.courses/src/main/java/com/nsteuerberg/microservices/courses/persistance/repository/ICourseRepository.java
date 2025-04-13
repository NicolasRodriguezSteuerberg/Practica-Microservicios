package com.nsteuerberg.microservices.courses.persistance.repository;

import com.nsteuerberg.microservices.courses.persistance.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends CrudRepository<CourseEntity, Long> {

}
