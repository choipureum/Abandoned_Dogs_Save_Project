package admin.dto;

import java.util.Date;

public class DogClaimDTO {
	
	private int dogno;
	private String dogname;
	private String dogkind;
	private String doggender;
	private String dogneu;
	private int dogshelter;
	private Date dogregdate;
	private String userid;
		
	public int getDogno() {
		return dogno;
	}

	public void setDogno(int dogno) {
		this.dogno = dogno;
	}

	public String getDogname() {
		return dogname;
	}

	public void setDogname(String dogname) {
		this.dogname = dogname;
	}

	public String getDogkind() {
		return dogkind;
	}
	public void setDogkind(String dogkind) {
		this.dogkind = dogkind;
	}
	public String getDoggender() {
		return doggender;
	}
	public void setDoggender(String doggender) {
		this.doggender = doggender;
	}
	public String getDogneu() {
		return dogneu;
	}
	public void setDogneu(String dogneu) {
		this.dogneu = dogneu;
	}
	public int getDogshelter() {
		return dogshelter;
	}
	public void setDogshelter(int dogshelter) {
		this.dogshelter = dogshelter;
	}
	public Date getDogregdate() {
		return dogregdate;
	}
	public void setDogregdate(Date dogregdate) {
		this.dogregdate = dogregdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "DogClaimDTO [dogno=" + dogno + ", dogname=" + dogname + ", dogkind=" + dogkind + ", doggender="
				+ doggender + ", dogneu=" + dogneu + ", dogshelter=" + dogshelter + ", dogregdate=" + dogregdate
				+ ", userid=" + userid + "]";
	}
	
	
}
