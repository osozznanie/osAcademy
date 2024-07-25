package com.school.osacademy.dto.response;

import com.school.osacademy.enums.LoginStatus;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponseDto {
    private String massage;
    private LoginStatus loginStatus;
    private UserDto userDto;
    private String token;
}
