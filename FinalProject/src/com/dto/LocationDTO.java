package com.dto;

public class LocationDTO {

	//관례적으로 user테이블의 컬럼명을 변수로 지정한다.
	int DID;
	String Gu;
	String Dong;
	long latitude;
	long longitude;
	
	
	public LocationDTO(String Gu, String Dong) {
		this.Gu = Gu;
		this.Dong = Dong;
	}

	
	@Override
	public String toString () {
		return "userDto[DID = "+DID+",Gu = "+Gu+",Dong = "+Dong+"]";
	}
	
	
	
}
