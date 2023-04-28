package com.service;

import com.dto.UserDTO;

public interface UserService {
    public int register(UserDTO dto);

    int logIn (UserDTO dto);

    public int delete(int UID);

}
