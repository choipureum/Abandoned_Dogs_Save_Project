package admin.dto;

import java.util.Date;

public class Dogout {
	private int dogno;
	private String dogname;
	private String dogkind;
	private String doggender;
	private String userid;
	private String dog_stored_file_name;
	private Date outdate; //입양날짜
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDog_stored_file_name() {
		return dog_stored_file_name;
	}
	public void setDog_stored_file_name(String dog_stored_file_name) {
		this.dog_stored_file_name = dog_stored_file_name;
	}
	public Date getOutdate() {
		return outdate;
	}
	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}
	@Override
	public String toString() {
		return "Dogout [dogno=" + dogno + ", dogname=" + dogname + ", dogkind=" + dogkind + ", doggender=" + doggender
				+ ", userid=" + userid + ", dog_stored_file_name=" + dog_stored_file_name + ", outdate=" + outdate
				+ "]";
	}
	
	
	
	
	
	
}
