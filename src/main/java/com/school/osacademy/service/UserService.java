package com.school.osacademy.service;

import com.school.osacademy.dto.request.CreateUserDto;
import com.school.osacademy.dto.request.LoginUserDto;
import com.school.osacademy.dto.response.LoginResponseDto;
import com.school.osacademy.dto.response.RegisterResponseDto;
import com.school.osacademy.dto.response.UserDto;
import java.util.List;

public interface UserService {

    RegisterResponseDto createUser(CreateUserDto createUserDto);

    LoginResponseDto loginUser(LoginUserDto loginUserDto);

    UserDto getUserByEmail(String email);

    List<UserDto> getAllUsers();

    void deleteUserByEmail(String email);

    boolean subscribeUser(String email);

    boolean unsubscribeUser(String email);

    boolean verifyUser(String email);

    boolean unverifyUser(String email);

    //TODO: use these methods in the future
//    void changeAvatar(String email, String avatar);
//    void changeName(String email, String name);
//    void changePassword(String email, String password);
//    void changeEmail(String email, String newEmail);
//    void changeIsSubscribed(String email, boolean isSubscribed);
//    void changeIsVerified(String email, boolean isVerified);
//    void addSubscription(String email, Subscription subscription);
//    void removeSubscription(String email, Subscription subscription);
//    void removeAllSubscriptions(String email);
//    void removeAllUsers();
}
