package bean;

import util.IpUtil;

/**
 * edited using github editor (2nd time)
 * */
public class IpDataDisplayBean {
	private boolean isError;
	private String errorMsg, country, state, city, ipAddr;
	
	private double longitude, latitude;
	
	public IpDataDisplayBean(){
		//init to unknown values
		country = state = city = ipAddr = IpUtil.UNKNOWN_VALUE;
	}
	
	public boolean getIsError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
}
