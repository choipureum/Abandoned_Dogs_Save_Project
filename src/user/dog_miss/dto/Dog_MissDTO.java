package user.dog_miss.dto;

import java.util.Date;

public class Dog_MissDTO {
	
	private int missno;
	private String missname;
	private String misskind;
	private String missgender;
	private Date missdate;
	private String missimg;
	private String missloc; 
	private String misstitle;
	private String misscontent;
	private String misswriter;
	private String misshit;
	public int getMissno() {
		return missno;
	}
	public void setMissno(int missno) {
		this.missno = missno;
	}
	public String getMissname() {
		return missname;
	}
	public void setMissname(String missname) {
		this.missname = missname;
	}
	public String getMisskind() {
		return misskind;
	}
	public void setMisskind(String misskind) {
		this.misskind = misskind;
	}
	public String getMissgender() {
		return missgender;
	}
	public void setMissgender(String missgender) {
		this.missgender = missgender;
	}
	public Date getMissdate() {
		return missdate;
	}
	public void setMissdate(Date missdate) {
		this.missdate = missdate;
	}
	public String getMissimg() {
		return missimg;
	}
	public void setMissimg(String missimg) {
		this.missimg = missimg;
	}
	public String getMissloc() {
		return missloc;
	}
	public void setMissloc(String missloc) {
		this.missloc = missloc;
	}
	public String getMisstitle() {
		return misstitle;
	}
	public void setMisstitle(String misstitle) {
		this.misstitle = misstitle;
	}
	public String getMisscontent() {
		return misscontent;
	}
	public void setMisscontent(String misscontent) {
		this.misscontent = misscontent;
	}
	public String getMisswriter() {
		return misswriter;
	}
	public void setMisswriter(String misswriter) {
		this.misswriter = misswriter;
	}
	public String getMisshit() {
		return misshit;
	}
	public void setMisshit(String misshit) {
		this.misshit = misshit;
	}
	@Override
	public String toString() {
		return "Dog_Miss_DTO [missno=" + missno + ", missname=" + missname + ", misskind=" + misskind + ", missgender="
				+ missgender + ", missdate=" + missdate + ", missimg=" + missimg + ", missloc=" + missloc
				+ ", misstitle=" + misstitle + ", misscontent=" + misscontent + ", misswriter=" + misswriter
				+ ", misshit=" + misshit + "]";
	}
	
	
}
