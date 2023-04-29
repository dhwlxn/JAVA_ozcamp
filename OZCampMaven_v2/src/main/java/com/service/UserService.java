package com.service;

import com.dto.UserDTO;

public interface UserService {
    int register(UserDTO dto);

    int logIn (UserDTO dto);

    int delete(int UID);

}
