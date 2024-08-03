package com.school.osacademy.repository;

import com.school.osacademy.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> getUserByEmail(String email);
    void deleteUserByEmail(String email);
}
