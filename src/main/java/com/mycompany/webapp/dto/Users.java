package com.mycompany.webapp.dto;
import java.util.Date;

public class Users {
	private String user_id;
	private String user_hospital_id;
	private String user_password;
	private String user_name;
	private String user_tel;
	private String user_email; 
	private String user_sex;
	private String user_zipcode;
	private String userAddress;
	private String user_detailaddress1;
	private String user_detailaddress2;
	private Date user_regdate;
	private int user_enabled;
	private String user_authority;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_hospital_id() {
		return user_hospital_id;
	}
	public void setUser_hospital_id(String user_hospital_id) {
		this.user_hospital_id = user_hospital_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_zipcode() {
		return user_zipcode;
	}
	public void setUser_zipcode(String user_zipcode) {
		this.user_zipcode = user_zipcode;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUser_detailaddress1() {
		return user_detailaddress1;
	}
	public void setUser_detailaddress1(String user_detailaddress1) {
		this.user_detailaddress1 = user_detailaddress1;
	}
	public String getUser_detailaddress2() {
		return user_detailaddress2;
	}
	public void setUser_detailaddress2(String user_detailaddress2) {
		this.user_detailaddress2 = user_detailaddress2;
	}
	public Date getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(Date user_regdate) {
		this.user_regdate = user_regdate;
	}
	public int getUser_enabled() {
		return user_enabled;
	}
	public void setUser_enabled(int user_enabled) {
		this.user_enabled = user_enabled;
	}
	public String getUser_authority() {
		return user_authority;
	}
	public void setUser_authority(String user_authority) {
		this.user_authority = user_authority;
	}
	
}
