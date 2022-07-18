package com.arang.medici.signup.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String passwd;
	private String Name;
	private String koreanName;
	private String englishName;
	private String ssn;
	private String acaBackGround;
	private String major;
	private String careerYear;
	private String careerType;
	private String company;
	private String portpolio;
	private String mainGenre;
	private String priceAvg;
	private String salesRate;
	private String mainArtwork;
	private String phoneNumber;
	private String email;
	private String sns;
	private List<User> userList;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getKoreanName() {
		return koreanName;
	}

	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getAcaBackGround() {
		return acaBackGround;
	}

	public void setAcaBackGround(String acaBackGround) {
		this.acaBackGround = acaBackGround;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCareerYear() {
		return careerYear;
	}

	public void setCareerYear(String careerYear) {
		this.careerYear = careerYear;
	}

	public String getCareerType() {
		return careerType;
	}

	public void setCareerType(String careerType) {
		this.careerType = careerType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPortpolio() {
		return portpolio;
	}

	public void setPortpolio(String portpolio) {
		this.portpolio = portpolio;
	}

	public String getMainGenre() {
		return mainGenre;
	}

	public void setMainGenre(String mainGenre) {
		this.mainGenre = mainGenre;
	}

	public String getPriceAvg() {
		return priceAvg;
	}

	public void setPriceAvg(String priceAvg) {
		this.priceAvg = priceAvg;
	}

	public String getSalesRate() {
		return salesRate;
	}

	public void setSalesRate(String salesRate) {
		this.salesRate = salesRate;
	}

	public String getMainArtwork() {
		return mainArtwork;
	}

	public void setMainArtwork(String mainArtwork) {
		this.mainArtwork = mainArtwork;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}
	
}
