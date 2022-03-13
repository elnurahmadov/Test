package com.aykan.dao.user;

import com.aykan.domain.user.User;

import java.util.List;

public interface UserRepository {
    User saveUser(User user);

    User updateUser(User user);

    User deleteUser(User user);

    User findUserById(Long id);

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    List<User> findAllUsers();
}
