package com.nsteuerberg.microservices.courses.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentsResponse {
    private String courseName;
    private String teacher;
    private List<StudentResponse> students;
}
