package user.dog.dto;

import java.util.Date;

public class Dog_List_DTO {
	private int dogno;
	private String dogtitle;
	private String dogcontent;
	private String dogwriter;
	private int doghit;
	private Date doglistdate;
	public int getDogno() {
		return dogno;
	}
	public void setDogno(int dogno) {
		this.dogno = dogno;
	}
	public String getDogtitle() {
		return dogtitle;
	}
	public void setDogtitle(String dogtitle) {
		this.dogtitle = dogtitle;
	}
	public String getDogcontent() {
		return dogcontent;
	}
	public void setDogcontent(String dogcontent) {
		this.dogcontent = dogcontent;
	}
	public String getDogwriter() {
		return dogwriter;
	}
	public void setDogwriter(String dogwriter) {
		this.dogwriter = dogwriter;
	}
	public int getDoghit() {
		return doghit;
	}
	public void setDoghit(int doghit) {
		this.doghit = doghit;
	}
	public Date getDoglistdate() {
		return doglistdate;
	}
	public void setDoglistdate(Date doglistdate) {
		this.doglistdate = doglistdate;
	}
	@Override
	public String toString() {
		return "Dog_List_DTO [dogno=" + dogno + ", dogtitle=" + dogtitle + ", dogcontent=" + dogcontent + ", dogwriter="
				+ dogwriter + ", doghit=" + doghit + ", doglistdate=" + doglistdate + "]";
	}
}
