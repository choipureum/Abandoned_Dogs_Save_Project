package user.qna.dto;

import java.util.Date;

public class QNA {
	private int qnaNO ;
	private String qnaTitle;
	private String qnaContent;
	private int qnaHit;
	private Date qnaDate;
	private String qnaImg;
	private String qnaWriter;
	public int getQnaNO() {
		return qnaNO;
	}
	
	
	public void setQnaNO(int qnaNO) {
		this.qnaNO = qnaNO;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public int getQnaHit() {
		return qnaHit;
	}
	public void setQnaHit(int qnaHit) {
		this.qnaHit = qnaHit;
	}
	public Date getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}
	public String getQnaImg() {
		return qnaImg;
	}
	public void setQnaImg(String qnaImg) {
		this.qnaImg = qnaImg;
	}
	public String getQnaWriter() {
		return qnaWriter;
	}
	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}
	@Override
	public String toString() {
		return "QNA [qnaNO=" + qnaNO + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", qnaHit=" + qnaHit
				+ ", qnaDate=" + qnaDate + ", qnaImg=" + qnaImg + ", qnaWriter=" + qnaWriter + "]";
	}
}
