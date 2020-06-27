package user.dog.dto;

import java.sql.Date;

public class UserLike {

	private String userid;
	private String adoptsw;
	private int applysw;
	private int dogno;
<<<<<<< HEAD
	
=======

>>>>>>> branch 'master' of https://github.com/choipureum/Abandoned_Dogs_Save_Project.git
	
	public int getApplysw() {
		return applysw;
	}
	public void setApplysw(int applysw) {
		this.applysw = applysw;
	}
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/choipureum/Abandoned_Dogs_Save_Project.git
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
