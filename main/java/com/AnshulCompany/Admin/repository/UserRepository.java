package com.AnshulCompany.Admin.repository;

import com.AnshulCompany.Admin.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Spring Data MongoDB will automatically provide implementations for:
    // save(), findById(), findAll(), deleteById(), etc.

    // You can add custom derived query methods here if needed, e.g.:
    Optional<User> findByName(String name); // Assuming 'name' is unique or you want to find by name
    boolean existsByName(String name);
}