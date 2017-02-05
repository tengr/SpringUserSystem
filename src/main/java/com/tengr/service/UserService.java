package com.tengr.service;

import com.tengr.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
