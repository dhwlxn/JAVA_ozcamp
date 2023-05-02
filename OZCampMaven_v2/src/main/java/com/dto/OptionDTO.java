package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok을 이용한 생성자 자동생성
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionDTO {
	
	double maxLat;
	double minLat;
	double maxLong;
	double minLong;
	
	char electricity;
    char wifi;
    char water_pool;
    char playground;
    char environment;
	
	

}
