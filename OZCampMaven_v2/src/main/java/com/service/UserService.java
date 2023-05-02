package com.service;

import com.dto.UserDTO;

public interface UserService {

    // 회원가입 시 CUID 배정하기 위해 maxvalue 값 가져오기
    int maxvalue();

    // 회원가입
    int register(UserDTO dto);

    // ID 중복확인
    int isIdDuplicated(String ID);

    // 로그인
    String logIn (UserDTO dto);

    // 로그인 시 해당 회원의 CUID 저장
    int getCUID (UserDTO dto);

    // 회원 탈퇴
    int delete(int CUID);

}
