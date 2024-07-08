package com.school.osacademy.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
    private String description;
    private String path;
}
