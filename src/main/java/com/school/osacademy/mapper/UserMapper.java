package com.school.osacademy.mapper;

import com.school.osacademy.dto.request.CreateUserDto;
import com.school.osacademy.dto.response.UserDto;
import com.school.osacademy.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toUserDtoFromModel(User user) {
        return UserDto.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .role(user.getRole())
            .subscriptions(user.getSubscriptions())
            .avatar(user.getAvatar())
            .registrationDate(user.getRegistrationDate())
            .isVerified(user.isVerified())
            .isSubscribed(user.isSubscribed())
            .build();
    }

    public User toUserFromDto(UserDto userDto) {
        return User.builder()
            .id(userDto.getId())
            .name(userDto.getName())
            .email(userDto.getEmail())
            .role(userDto.getRole())
            .subscriptions(userDto.getSubscriptions())
            .avatar(userDto.getAvatar())
            .registrationDate(userDto.getRegistrationDate())
            .isVerified(userDto.isVerified())
            .isSubscribed(userDto.isSubscribed())
            .build();
    }

    public User toUserFromRequest(CreateUserDto userDto) {
          return User.builder()
            .name(userDto.getName())
            .email(userDto.getEmail())
            .role(userDto.getRole())
            .isSubscribed(userDto.isSubscribed())
            .avatar(userDto.getAvatar())
            .build();
    }

    public UserDto toUserDtoFromRequest(CreateUserDto userDto) {
        return UserDto.builder()
            .name(userDto.getName())
            .email(userDto.getEmail())
            .role(userDto.getRole())
            .isSubscribed(userDto.isSubscribed())
            .avatar(userDto.getAvatar())
            .build();
    }

}
