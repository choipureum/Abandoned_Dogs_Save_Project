package user.qna.dto;

import java.util.Date;

public class Qna_Reply {
	private String ref_title;
	private String ref_content;
	private Date ref_date;
	private int qnano;
	public String getRef_title() {
		return ref_title;
	}
	public void setRef_title(String ref_title) {
		this.ref_title = ref_title;
	}
	public String getRef_content() {
		return ref_content;
	}
	public void setRef_content(String ref_content) {
		this.ref_content = ref_content;
	}
	public Date getRef_date() {
		return ref_date;
	}
	public void setRef_date(Date ref_date) {
		this.ref_date = ref_date;
	}
	public int getQnano() {
		return qnano;
	}
	public void setQnano(int qnano) {
		this.qnano = qnano;
	}
	@Override
	public String toString() {
		return "Qna_Reply [ref_title=" + ref_title + ", ref_content=" + ref_content + ", ref_date=" + ref_date
				+ ", qnano=" + qnano + "]";
	}

	
	
}
