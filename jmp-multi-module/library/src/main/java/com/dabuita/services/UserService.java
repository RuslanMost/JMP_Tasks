package com.dabuita.services;

import com.dabuita.models.User;

public interface UserService {
    User findUserByEmail(String email);

    void saveUser(User user);
}
