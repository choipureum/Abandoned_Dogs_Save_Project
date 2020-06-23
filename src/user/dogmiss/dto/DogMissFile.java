package user.dogmiss.dto;

public class DogMissFile {
	private int missNo;
	private int miss_fileNO;
	private String miss_org_FILE_NAME;
	private String miss_stored_FILE_NAME;
	private double miss_FILE_SIZE;
	private String miss_DEL_GB;
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
	@Override
	public String toString() {
		return "DogMissFile [missNo=" + missNo + ", miss_fileNO=" + miss_fileNO + ", miss_org_FILE_NAME="
				+ miss_org_FILE_NAME + ", miss_stored_FILE_NAME=" + miss_stored_FILE_NAME + ", miss_FILE_SIZE="
				+ miss_FILE_SIZE + ", miss_DEL_GB=" + miss_DEL_GB + "]";
	} 

}	
