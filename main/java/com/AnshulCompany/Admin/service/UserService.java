package com.AnshulCompany.Admin.service;

import com.AnshulCompany.Admin.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(String id); // Changed ID type to String
    User updateUser(String id, User user); // Changed ID type to String
    void deleteUser(String id); // Changed ID type to String
}