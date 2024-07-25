package com.school.osacademy.enums;

import lombok.Getter;

@Getter
public enum LoginStatus {
    SUCCESS("Login successful"),
    FAILED("Login failed");

    private final String message;

    LoginStatus(String message) {
        this.message = message;
    }
}
