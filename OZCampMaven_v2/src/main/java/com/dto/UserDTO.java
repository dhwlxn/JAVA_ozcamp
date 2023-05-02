package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok을 이용한 생성자 자동생성
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    int CUID;
    String ID;
    String PW;

}
