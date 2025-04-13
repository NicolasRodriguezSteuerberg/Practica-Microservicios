package com.nsteuerberg.microservices.courses.service.http;

import com.nsteuerberg.microservices.courses.presentation.dto.response.StudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
    name = "microservices.students",
    url = "localhost:8081/api/student"
)
public interface IStudentClient {

    @GetMapping("{idCourse}")
    List<StudentResponse> findAllStudentById(@PathVariable Long idCourse);
}
