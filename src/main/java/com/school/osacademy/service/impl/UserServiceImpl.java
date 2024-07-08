package com.school.osacademy.service.impl;

import com.school.osacademy.dto.request.CreateUserDto;
import com.school.osacademy.dto.response.UserDto;
import com.school.osacademy.mapper.UserMapper;
import com.school.osacademy.model.User;
import com.school.osacademy.repository.UserRepository;
import com.school.osacademy.service.UserService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        User userFromRequest = repository.save(userMapper.toUserFromRequest(createUserDto));
        return userMapper.toUserDtoFromModel(userFromRequest);
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
            User userByEmail = getUserByEmailAndReturnUser(email);
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
            User userByEmail = getUserByEmailAndReturnUser(email);
            userByEmail.setVerified(false);
            repository.save(userByEmail);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private User getUserByEmailAndReturnUser(String email) {
        UserDto userDTO = getUserByEmail(email);
        return userMapper.toUserFromDto(userDTO);
    }
}
