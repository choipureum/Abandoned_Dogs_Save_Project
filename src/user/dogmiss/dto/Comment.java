package user.dogmiss.dto;

import java.util.Date;

public class Comment {
	
	private int missNo;
	private int miss_rno;
	private String miss_writer;
	private String miss_content;
	private Date miss_date;
	public int getMissNo() {
		return missNo;
	}
	public void setMissNo(int missNo) {
		this.missNo = missNo;
	}
	public int getMiss_rno() {
		return miss_rno;
	}
	public void setMiss_rno(int miss_rno) {
		this.miss_rno = miss_rno;
	}
	public String getMiss_writer() {
		return miss_writer;
	}
	public void setMiss_writer(String miss_writer) {
		this.miss_writer = miss_writer;
	}
	public String getMiss_content() {
		return miss_content;
	}
	public void setMiss_content(String miss_content) {
		this.miss_content = miss_content;
	}
	public Date getMiss_date() {
		return miss_date;
	}
	public void setMiss_date(Date miss_date) {
		this.miss_date = miss_date;
	}
	@Override
	public String toString() {
		return "Comment [missNo=" + missNo + ", miss_rno=" + miss_rno + ", miss_writer=" + miss_writer
				+ ", miss_content=" + miss_content + ", miss_date=" + miss_date + "]";
	}
	

}
