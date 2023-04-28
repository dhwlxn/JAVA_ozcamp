package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok을 이용한 생성자 자동생성
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampDTO {
    int CID;
    String name;
    String address;
    double latitude;
    double longitude;
    char commonsite;
    char caravansite;
    char glampingsite;
    char autosite;
    char electricity;
    char wifi;
    char waterpool;
    char playground;
    char environment;
    String features;


}
