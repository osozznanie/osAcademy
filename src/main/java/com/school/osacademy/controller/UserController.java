package com.school.osacademy.controller;

import com.school.osacademy.dto.request.CreateUserDto;
import com.school.osacademy.dto.request.LoginUserDto;
import com.school.osacademy.dto.response.LoginResponseDto;
import com.school.osacademy.dto.response.RegisterResponseDto;
import com.school.osacademy.dto.response.UserDto;
import com.school.osacademy.mapper.UserMapper;
import com.school.osacademy.model.User;
import com.school.osacademy.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
@Validated
@CrossOrigin(origins = "http://localhost:9090")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> createUser(@RequestBody CreateUserDto createUserDto) {
        RegisterResponseDto response = userService.createUser(createUserDto);
        return switch (response.getRegisterStatus()) {
            case SUCCESS -> ResponseEntity.status(HttpStatus.CREATED).body(response);
            case EMAIL_ALREADY_EXISTS -> ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        };
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginUserDto loginUser) {
        LoginResponseDto response = userService.loginUser(loginUser);
        return switch (response.getLoginStatus()) {
            case SUCCESS -> ResponseEntity.status(HttpStatus.CREATED).body(response);
            case FAILED -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        };
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/email")
    public ResponseEntity<UserDto> getUserByEmail(@RequestBody String email) {
        UserDto userDto = userService.getUserByEmail(email);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email) {
        userService.deleteUserByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/unsubscribe/{email}")
    public ResponseEntity<Boolean> unsubscribeUser(@PathVariable String email) {
        boolean isUnSubscriber = userService.unsubscribeUser(email);
        return ResponseEntity.ok(isUnSubscriber);
    }

    @PutMapping("/subscribe/{email}")
    public ResponseEntity<Boolean> subscribeUser(@PathVariable String email) {
        boolean isSubscriber = userService.subscribeUser(email);
        return ResponseEntity.ok(isSubscriber);
    }

    @PutMapping("/verify/{email}")
    public ResponseEntity<Boolean> verifyUser(@PathVariable String email) {
        boolean isVerifyUser = userService.verifyUser(email);
        return ResponseEntity.ok(isVerifyUser);
    }

    @PutMapping("/unverify/{email}")
    public ResponseEntity<Boolean> unverifyUser(@PathVariable String email) {
        boolean isUnverifyUser = userService.unverifyUser(email);
        return ResponseEntity.ok(isUnverifyUser);
    }
}


