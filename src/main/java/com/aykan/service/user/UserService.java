package com.aykan.service.user;

import com.aykan.domain.user.User;
import com.aykan.web.dto.UserDto;

import java.util.List;
//service for repository
public interface UserService {
    User registerNewUser(UserDto userDto);

    boolean checkIfValidOldPassword(User user, String oldPassword);

    void changeUserPassword(User user, String password);

    User saveUser(User user);

    User updateUser(User user);

    User deleteUser(User user);

    User findUserById(Long id);

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    List<User> findAllUsers();
}
