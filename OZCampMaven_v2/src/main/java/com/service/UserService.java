package com.service;

import java.util.List;

import com.dto.UserDTO;

public interface UserService {
    int register(UserDTO dto);

    String logIn (UserDTO dto);

    int getCUID (UserDTO dto);
    
    int delete(int CUID);
    
    List<UserDTO> findAll();
    
}
