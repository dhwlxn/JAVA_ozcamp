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
    char common_site;
    char caravan_site;
    char glamping_site;
    char auto_site;
    char electricity;
    char wifi;
    char water_pool;
    char playground;
    char environment;
    String features;


}
