package com.school.osacademy.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserDto {

    //    private String name;
//    @NotBlank(message = "Username can't be empty")
    //private String username;
    @NotBlank(message = "Email can't be empty")
//    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
//        message = "Invalid email")
    private String email;
    @NotBlank(message = "Password can't be empty")
    private String password;

//    private String avatar;
//    private ERole role;
//    private boolean isSubscribed;

}
