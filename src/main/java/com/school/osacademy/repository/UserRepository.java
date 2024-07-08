package com.school.osacademy.repository;

import com.school.osacademy.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> getUserByEmail(String email);
    void deleteUserByEmail(String email);
}
