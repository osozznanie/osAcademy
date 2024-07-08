package com.school.osacademy.dto.request;

import com.school.osacademy.enums.ERole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserDto {
    private String name;
    private String email;
    private String password;
    private String avatar;
    private ERole role;
    private boolean isSubscribed;
}
