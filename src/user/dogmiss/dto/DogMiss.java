package user.dogmiss.dto;

import java.util.Date;

public class DogMiss {
	private int missNO;
	private String missName;
	private String missKind;
	private String missGender;
	private Date missDate;
	private String missImg;
	public int getMissNO() {
		return missNO;
	}
	public void setMissNO(int missNO) {
		this.missNO = missNO;
	}
	public String getMissName() {
		return missName;
	}
	public void setMissName(String missName) {
		this.missName = missName;
	}
	public String getMissKind() {
		return missKind;
	}
	public void setMissKind(String missKind) {
		this.missKind = missKind;
	}
	public String getMissGender() {
		return missGender;
	}
	public void setMissGender(String missGender) {
		this.missGender = missGender;
	}
	public Date getMissDate() {
		return missDate;
	}
	public void setMissDate(Date missDate) {
		this.missDate = missDate;
	}
	public String getMissImg() {
		return missImg;
	}
	public void setMissImg(String missImg) {
		this.missImg = missImg;
	}
	public String getMissLoc() {
		return missLoc;
	}
	public void setMissLoc(String missLoc) {
		this.missLoc = missLoc;
	}
	public String getMissTitle() {
		return missTitle;
	}
	public void setMissTitle(String missTitle) {
		this.missTitle = missTitle;
	}
	public String getMissContent() {
		return missContent;
	}
	public void setMissContent(String missContent) {
		this.missContent = missContent;
	}
	public String getMissWriter() {
		return missWriter;
	}
	public void setMissWriter(String missWriter) {
		this.missWriter = missWriter;
	}
	public int getMissHit() {
		return missHit;
	}
	public void setMissHit(int missHit) {
		this.missHit = missHit;
	}
	@Override
	public String toString() {
		return "DogMiss [missNO=" + missNO + ", missName=" + missName + ", missKind=" + missKind + ", missGender="
				+ missGender + ", missDate=" + missDate + ", missImg=" + missImg + ", missLoc=" + missLoc
				+ ", missTitle=" + missTitle + ", missContent=" + missContent + ", missWriter=" + missWriter
				+ ", missHit=" + missHit + "]";
	}
	private String missLoc;
	private String missTitle;
	private String missContent;
	private String missWriter;
	private int missHit;
	
}
