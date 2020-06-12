package user.dog_miss.dto;

import java.util.Date;

public class Dog_Miss_ReplyDTO {

	private int missno;
	private String miss_rno;
	private String miss_content;
	private String miss_writer;
	private Date miss_date;
	public int getMissno() {
		return missno;
	}
	public void setMissno(int missno) {
		this.missno = missno;
	}
	public String getMiss_rno() {
		return miss_rno;
	}
	public void setMiss_rno(String miss_rno) {
		this.miss_rno = miss_rno;
	}
	public String getMiss_content() {
		return miss_content;
	}
	public void setMiss_content(String miss_content) {
		this.miss_content = miss_content;
	}
	public String getMiss_writer() {
		return miss_writer;
	}
	public void setMiss_writer(String miss_writer) {
		this.miss_writer = miss_writer;
	}
	public Date getMiss_date() {
		return miss_date;
	}
	public void setMiss_date(Date miss_date) {
		this.miss_date = miss_date;
	}
	@Override
	public String toString() {
		return "Dog_Miss_ReplyDTO [missno=" + missno + ", miss_rno=" + miss_rno + ", miss_content=" + miss_content
				+ ", miss_writer=" + miss_writer + ", miss_date=" + miss_date + "]";
	}
	
	
}
