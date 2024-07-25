package com.school.osacademy.service.impl;

import static com.school.osacademy.enums.RegisterStatus.EMAIL_ALREADY_EXISTS;
import static java.util.Objects.nonNull;

import com.school.osacademy.dto.request.CreateUserDto;
import com.school.osacademy.dto.request.LoginUserDto;
import com.school.osacademy.dto.response.LoginResponseDto;
import com.school.osacademy.dto.response.RegisterResponseDto;
import com.school.osacademy.dto.response.UserDto;
import com.school.osacademy.enums.LoginStatus;
import com.school.osacademy.enums.RegisterStatus;
import com.school.osacademy.mapper.UserMapper;
import com.school.osacademy.model.User;
import com.school.osacademy.repository.UserRepository;
import com.school.osacademy.security.jwt.JwtTokenUtils;
import com.school.osacademy.service.UserService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenUtils jwtTokenUtils;

    @Override
    public RegisterResponseDto createUser(CreateUserDto createUserDto) {
        try {
            getUserByEmail(createUserDto.getEmail());
            return RegisterResponseDto.builder()
                .message("User with email " + createUserDto.getEmail() + " already exists")
                .registerStatus(EMAIL_ALREADY_EXISTS)
                .build();
        } catch (NoSuchElementException e) {
            User user = userMapper.toUserFromRequest(createUserDto);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
            return RegisterResponseDto.builder()
                .message(RegisterStatus.SUCCESS.getMessage())
                .registerStatus(RegisterStatus.SUCCESS)
                .userDto(userMapper.toUserDtoFromModel(user))
                .build();
        }
    }

    @Override
    public LoginResponseDto loginUser(LoginUserDto loginUserDto) {
        User userByEmail = repository.getUserByEmail(loginUserDto.getEmail()).orElse(null);
        if (nonNull(userByEmail) && passwordEncoder.matches(loginUserDto.getPassword(), userByEmail.getPassword())) {
            return LoginResponseDto.builder()
                .massage("Login successful")
                .loginStatus(LoginStatus.SUCCESS)
                .email(userByEmail.getEmail())
                .token(jwtTokenUtils.generateToken(userByEmail))
                .build();
        } else {
            return LoginResponseDto.builder()
                .massage(LoginStatus.FAILED.getMessage())
                .loginStatus(LoginStatus.FAILED)
                .build();
        }
    }

    @Override
    public UserDto getUserByEmail(String email) {
        Optional<User> userByEmail = repository.getUserByEmail(email);
        return userByEmail
            .map(userMapper::toUserDtoFromModel)
            .orElseThrow(() -> new NoSuchElementException("User with email " + email + " not found"));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repository.findAll()
            .stream()
            .map(userMapper::toUserDtoFromModel)
            .toList();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUserByEmail(String email) {
        repository.deleteUserByEmail(email);
    }

    @Override
    public boolean subscribeUser(String email) {
        try {
            UserDto userDTO = getUserByEmail(email);
            User userByEmail = userMapper.toUserFromDto(userDTO);
            userByEmail.setSubscribed(true);
            repository.save(userByEmail);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean unsubscribeUser(String email) {
        try {
            UserDto userDTO = getUserByEmail(email);
            User userByEmail = userMapper.toUserFromDto(userDTO);
            userByEmail.setSubscribed(false);
            repository.save(userByEmail);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean verifyUser(String email) {
        try {
            User userByEmail = userMapper.toUserFromDto(getUserByEmail(email));
            userByEmail.setVerified(true);
            repository.save(userByEmail);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean unverifyUser(String email) {
        try {
            User userByEmail = userMapper.toUserFromDto(getUserByEmail(email));
            userByEmail.setVerified(false);
            repository.save(userByEmail);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
