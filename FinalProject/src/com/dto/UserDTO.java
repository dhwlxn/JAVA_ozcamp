package com.dto;

public class UserDTO {

	//관례적으로 user테이블의 컬럼명을 변수로 지정한다.
	int UID;
	String ID;
	String PW;

	public UserDTO(int UID) {
		this(UID, "", "");
	}
	public UserDTO(int UID, String ID, String PW) {
		this.UID = UID;
		this.ID = ID;
		this.PW = PW;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int UID) {
		this.UID = UID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String PW) {
		this.PW = PW;
	}
	
	@Override
	public String toString () {
		return "userDto[UID = "+UID+",ID = "+ID+",PW = "+PW+"]";
	}
	
	
	
}
