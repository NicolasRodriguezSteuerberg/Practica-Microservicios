package com.nsteuerberg.microservices.courses.presentation.dto.response;

import lombok.*;

@Value
@Data
public class StudentResponse{
    String name;
    String lastName;
    String email;
    Long courseId;
}
