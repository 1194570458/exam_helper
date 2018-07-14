package com.kason.app.service;

import com.kason.app.entity.User;

public interface UserService {
    User addUser(User user);

    User getUser(String username, String password);

    User getUser(String token);

    User updateUser(User user);
}
