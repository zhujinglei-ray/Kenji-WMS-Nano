package com.kenji.wms.repository;

import com.kenji.wms.model.login.User;

public interface UserRepo {
    User findByEmail(String email);
    String saveUser(User user);
}
