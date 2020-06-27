package user.dog.dto;

import java.sql.Date;

public class UserLike {

	private String userid;
	private String adoptsw;
	private int applysw;
	private int dogno;
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
	public int getDogno() {
		return dogno;
	}
	public void setDogno(int dogno) {
		this.dogno = dogno;
	}
	@Override
	public String toString() {
		return "UserLike [userid=" + userid + ", adoptsw=" + adoptsw + ", applysw=" + applysw + ", dogno=" + dogno
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
