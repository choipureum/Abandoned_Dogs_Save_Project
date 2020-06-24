package user.dogmiss.dto;

import java.util.Date;

public class DogMissAdd {
	private int missNO;
	private String missName;
	private String missKind;
	
	
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
	@Override
	public String toString() {
		return "DogMissAdd [missNO=" + missNO + ", missName=" + missName + ", missKind=" + missKind + ", missGender="
				+ missGender + ", missDate=" + missDate + ", missImg=" + missImg + ", missNo=" + missNo + ", missLoc="
				+ missLoc + ", missTitle=" + missTitle + ", missContent=" + missContent + ", missWriter=" + missWriter
				+ ", missHit=" + missHit + ", miss_fileNO=" + miss_fileNO + ", miss_org_FILE_NAME=" + miss_org_FILE_NAME
				+ ", miss_stored_FILE_NAME=" + miss_stored_FILE_NAME + ", miss_FILE_SIZE=" + miss_FILE_SIZE
				+ ", miss_DEL_GB=" + miss_DEL_GB + "]";
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
	private String missGender;
	private Date missDate;
	private String missImg;
	private int missNo;
	private String missLoc;
	private String missTitle;
	private String missContent;
	private String missWriter;
	private int missHit;
	
	
	
	
	
	
	
	private int miss_fileNO;
	private String miss_org_FILE_NAME;
	private String miss_stored_FILE_NAME;
	private double miss_FILE_SIZE;
	private String miss_DEL_GB;
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
	public int getMissNo() {
		return missNo;
	}
	public void setMissNo(int missNo) {
		this.missNo = missNo;
	}
	public int getMiss_fileNO() {
		return miss_fileNO;
	}
	public void setMiss_fileNO(int miss_fileNO) {
		this.miss_fileNO = miss_fileNO;
	}
	public String getMiss_org_FILE_NAME() {
		return miss_org_FILE_NAME;
	}
	public void setMiss_org_FILE_NAME(String miss_org_FILE_NAME) {
		this.miss_org_FILE_NAME = miss_org_FILE_NAME;
	}
	public String getMiss_stored_FILE_NAME() {
		return miss_stored_FILE_NAME;
	}
	public void setMiss_stored_FILE_NAME(String miss_stored_FILE_NAME) {
		this.miss_stored_FILE_NAME = miss_stored_FILE_NAME;
	}
	public double getMiss_FILE_SIZE() {
		return miss_FILE_SIZE;
	}
	public void setMiss_FILE_SIZE(double miss_FILE_SIZE) {
		this.miss_FILE_SIZE = miss_FILE_SIZE;
	}
	public String getMiss_DEL_GB() {
		return miss_DEL_GB;
	}
	public void setMiss_DEL_GB(String miss_DEL_GB) {
		this.miss_DEL_GB = miss_DEL_GB;
	}
	

}
