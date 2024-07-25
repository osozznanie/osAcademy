package com.school.osacademy.enums;

import lombok.Getter;

@Getter
public enum RegisterStatus {
    SUCCESS("User registered successfully"),
    EMAIL_ALREADY_EXISTS("Email already exists"),
    FAILED("User registration failed");

    private final String message;

    RegisterStatus(String message) {
        this.message = message;
    }
}
