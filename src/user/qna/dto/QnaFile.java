package user.qna.dto;

public class QnaFile {
	private int qnaNo;
	private int qna_fileNo;
	private String qna_org_FILE_NAME;
	private String qna_stored_FILR_NAME;
	private double qna_FILE_SIZE;
	private String qna_DEL_GB;
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public int getQna_fileNo() {
		return qna_fileNo;
	}
	public void setQna_fileNo(int qna_fileNo) {
		this.qna_fileNo = qna_fileNo;
	}
	public String getQna_org_FILE_NAME() {
		return qna_org_FILE_NAME;
	}
	public void setQna_org_FILE_NAME(String qna_org_FILE_NAME) {
		this.qna_org_FILE_NAME = qna_org_FILE_NAME;
	}
	public String getQna_stored_FILE_NAME() {
		return qna_stored_FILR_NAME;
	}
	public void setQna_stored_FILE_NAME(String qna_stored_FILR_NAME) {
		this.qna_stored_FILR_NAME = qna_stored_FILR_NAME;
	}
	public double getQna_FILE_SIZE() {
		return qna_FILE_SIZE;
	}
	public void setQna_FILE_SIZE(double qna_FILE_SIZE) {
		this.qna_FILE_SIZE = qna_FILE_SIZE;
	}
	public String getQna_DEL_GB() {
		return qna_DEL_GB;
	}
	public void setQna_DEL_GB(String qna_DEL_GB) {
		this.qna_DEL_GB = qna_DEL_GB;
	}
	@Override
	public String toString() {
		return "QnaFile [qnaNo=" + qnaNo + ", qna_fileNo=" + qna_fileNo + ", qna_org_FILE_NAME=" + qna_org_FILE_NAME
				+ ", qna_stored_FILR_NAME=" + qna_stored_FILR_NAME + ", qna_FILE_SIZE=" + qna_FILE_SIZE
				+ ", qna_DEL_GB=" + qna_DEL_GB + "]";
	}
	
}