package user.dog.dto;

import java.util.Date;

public class Dog {
	private int dogno;
	private String dogname;
	private String dogkind;
	private String doggender;
	private String dogneu;
	private Date dogdate;
	private String dogimg;
	private int shelterno;
	public int getDogno() {
		return dogno;
	}
	@Override
	public String toString() {
		return "Dog [dogno=" + dogno + ", dogname=" + dogname + ", dogkind=" + dogkind + ", doggender=" + doggender
				+ ", dogneu=" + dogneu + ", dogdate=" + dogdate + ", dogimg=" + dogimg + ", shelterno=" + shelterno
				+ "]";
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
	public Date getDogdate() {
		return dogdate;
	}
	public void setDogdate(Date dogdate) {
		this.dogdate = dogdate;
	}
	public String getDogimg() {
		return dogimg;
	}
	public void setDogimg(String dogimg) {
		this.dogimg = dogimg;
	}
	public int getShelterno() {
		return shelterno;
	}
	public void setShelterno(int shelterno) {
		this.shelterno = shelterno;
	}
}
