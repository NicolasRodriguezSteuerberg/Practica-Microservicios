package com.nsteuerberg.microservices.students.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "lastName", "email", "courseId"})
public record StudentResponse (
        String name,
        String lastName,
        String email,
        Long courseId
){
}
