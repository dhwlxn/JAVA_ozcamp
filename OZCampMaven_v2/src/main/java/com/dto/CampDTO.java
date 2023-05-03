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
    int common_site;
    int caravan_site;
    int glamping_site;
    int auto_site;
    int electricity;
    int wifi;
    int water_pool;
    int playground;
    int environment;
    String features;


}
