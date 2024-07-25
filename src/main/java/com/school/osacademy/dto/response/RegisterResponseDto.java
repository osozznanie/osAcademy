package com.school.osacademy.dto.response;

import com.school.osacademy.enums.RegisterStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponseDto {
    private RegisterStatus registerStatus;
    private String message;
    private UserDto userDto;
}
