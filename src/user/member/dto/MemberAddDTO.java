package user.member.dto;

import java.util.Date;

public class MemberAddDTO {
	
	//dog에 대한 멤버필드
	private int dogNo;
	private String dogName; 
	private String dogKind; 
	private String dogGender;
	private String dogNeu;
	private Date dogDate;
	private String dogImg; 
	private int shelterNo;
	private Date dogEndDate; 
	
	
	@Override
	public String toString() {
		return "MemberAddDTO [dogNo=" + dogNo + ", dogName=" + dogName + ", dogKind=" + dogKind + ", dogGender="
				+ dogGender + ", dogNeu=" + dogNeu + ", dogDate=" + dogDate + ", dogImg=" + dogImg + ", shelterNo="
				+ shelterNo + ", dogEndDate=" + dogEndDate + ", dog_fileNo=" + dog_fileNo + ", dog_org_FILE_NAME="
				+ dog_org_FILE_NAME + ", dog_stored_FILE_NAME=" + dog_stored_FILE_NAME + ", dog_FILE_SIZE="
				+ dog_FILE_SIZE + ", dog_DEL_GB=" + dog_DEL_GB + ", userid=" + userid + ", adoptsw=" + adoptsw
				+ ", applysw=" + applysw +"]";
	}
	public int getDogNo() {
		return dogNo;
	}
	public void setDogNo(int dogNo) {
		this.dogNo = dogNo;
	}
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public String getDogKind() {
		return dogKind;
	}
	public void setDogKind(String dogKind) {
		this.dogKind = dogKind;
	}
	public String getDogGender() {
		return dogGender;
	}
	public void setDogGender(String dogGender) {
		this.dogGender = dogGender;
	}
	public String getDogNeu() {
		return dogNeu;
	}
	public void setDogNeu(String dogNeu) {
		this.dogNeu = dogNeu;
	}
	public Date getDogDate() {
		return dogDate;
	}
	public void setDogDate(Date dogDate) {
		this.dogDate = dogDate;
	}
	public String getDogImg() {
		return dogImg;
	}
	public void setDogImg(String dogImg) {
		this.dogImg = dogImg;
	}
	public int getShelterNo() {
		return shelterNo;
	}
	public void setShelterNo(int shelterNo) {
		this.shelterNo = shelterNo;
	}
	public Date getDogEndDate() {
		return dogEndDate;
	}
	public void setDogEndDate(Date dogEndDate) {
		this.dogEndDate = dogEndDate;
	}
	public int getDog_fileNo() {
		return dog_fileNo;
	}
	public void setDog_fileNo(int dog_fileNo) {
		this.dog_fileNo = dog_fileNo;
	}
	public String getDog_org_FILE_NAME() {
		return dog_org_FILE_NAME;
	}
	public void setDog_org_FILE_NAME(String dog_org_FILE_NAME) {
		this.dog_org_FILE_NAME = dog_org_FILE_NAME;
	}
	public String getDog_stored_FILE_NAME() {
		return dog_stored_FILE_NAME;
	}
	public void setDog_stored_FILE_NAME(String dog_stored_FILE_NAME) {
		this.dog_stored_FILE_NAME = dog_stored_FILE_NAME;
	}
	public int getDog_FILE_SIZE() {
		return dog_FILE_SIZE;
	}
	public void setDog_FILE_SIZE(int dog_FILE_SIZE) {
		this.dog_FILE_SIZE = dog_FILE_SIZE;
	}
	public String getDog_DEL_GB() {
		return dog_DEL_GB;
	}
	public void setDog_DEL_GB(String dog_DEL_GB) {
		this.dog_DEL_GB = dog_DEL_GB;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAdoptsw() {
		return adoptsw;
	}
	public void setAdoptsw(String adoptsw) {
		this.adoptsw = adoptsw;
	}
	public int getApplysw() {
		return applysw;
	}
	public void setApplysw(int applysw) {
		this.applysw = applysw;
	}
	
	
	//dogfile에 대한 멤버필드//private dogNo이 겹치는건 없어도 되나?
	private int dog_fileNo;
	private String dog_org_FILE_NAME;
	private String dog_stored_FILE_NAME; 
	private int dog_FILE_SIZE; 
	private String dog_DEL_GB;
	
	
	//userlike에 대한 멤버필드 
	private String userid;
	private String adoptsw;
	private int applysw;
	
	
	
	
	
	
	
	

}
