package com.dto;

public class CampDTO {

	//관례적으로 dept테이블의 컬럼명을 변수로 지정한다.
	int CID;
	String name;
	String address;
	long latitude;
	long longitude;
	Boolean commonsite;
	Boolean caravansite;
	Boolean glampingsite;
	Boolean autosite;
	Boolean electricity;
	Boolean wifi;
	Boolean waterpool;
	Boolean playground;
	Boolean environment;
	String features;
	
	
	//검색할 때 간략하게 나오는 정보
	public CampDTO(String name) {
		this.name = name;
	}
	@Override
	public String toString () {
		return "DeptDto[CID = "+CID+",name = "+name+",address = "+address+"]";
	}
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		CID = cID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	public Boolean getCommonsite() {
		return commonsite;
	}
	public void setCommonsite(Boolean commonsite) {
		this.commonsite = commonsite;
	}
	public Boolean getCaravansite() {
		return caravansite;
	}
	public void setCaravansite(Boolean caravansite) {
		this.caravansite = caravansite;
	}
	public Boolean getGlampingsite() {
		return glampingsite;
	}
	public void setGlampingsite(Boolean glampingsite) {
		this.glampingsite = glampingsite;
	}
	public Boolean getAutosite() {
		return autosite;
	}
	public void setAutosite(Boolean autosite) {
		this.autosite = autosite;
	}
	public Boolean getElectricity() {
		return electricity;
	}
	public void setElectricity(Boolean electricity) {
		this.electricity = electricity;
	}
	public Boolean getWifi() {
		return wifi;
	}
	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}
	public Boolean getWaterpool() {
		return waterpool;
	}
	public void setWaterpool(Boolean waterpool) {
		this.waterpool = waterpool;
	}
	public Boolean getPlayground() {
		return playground;
	}
	public void setPlayground(Boolean playground) {
		this.playground = playground;
	}
	public Boolean getEnvironment() {
		return environment;
	}
	public void setEnvironment(Boolean environment) {
		this.environment = environment;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
}
