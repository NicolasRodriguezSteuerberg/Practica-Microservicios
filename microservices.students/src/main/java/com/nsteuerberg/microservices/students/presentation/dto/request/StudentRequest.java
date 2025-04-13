package com.nsteuerberg.microservices.students.presentation.dto.request;

public record StudentRequest (
    String name,
    String lastName,
    String email,
    Long courseId
){
}
