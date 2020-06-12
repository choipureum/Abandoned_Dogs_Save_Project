package user.dog_miss.dto;

public class Dog_Miss_FileDTO {
	
	private int missno;
	private String miss_fileno;
	private String miss_org_file_name;
	private String miss_stored_file_name;
	private int miss_file_size;
	private String miss_del_gb;
	public int getMissno() {
		return missno;
	}
	public void setMissno(int missno) {
		this.missno = missno;
	}
	public String getMiss_fileno() {
		return miss_fileno;
	}
	public void setMiss_fileno(String miss_fileno) {
		this.miss_fileno = miss_fileno;
	}
	public String getMiss_org_file_name() {
		return miss_org_file_name;
	}
	public void setMiss_org_file_name(String miss_org_file_name) {
		this.miss_org_file_name = miss_org_file_name;
	}
	public String getMiss_stored_file_name() {
		return miss_stored_file_name;
	}
	public void setMiss_stored_file_name(String miss_stored_file_name) {
		this.miss_stored_file_name = miss_stored_file_name;
	}
	public int getMiss_file_size() {
		return miss_file_size;
	}
	public void setMiss_file_size(int miss_file_size) {
		this.miss_file_size = miss_file_size;
	}
	public String getMiss_del_gb() {
		return miss_del_gb;
	}
	public void setMiss_del_gb(String miss_del_gb) {
		this.miss_del_gb = miss_del_gb;
	}
	@Override
	public String toString() {
		return "Dog_File_DTO [missno=" + missno + ", miss_fileno=" + miss_fileno + ", miss_org_file_name="
				+ miss_org_file_name + ", miss_stored_file_name=" + miss_stored_file_name + ", miss_file_size="
				+ miss_file_size + ", miss_del_gb=" + miss_del_gb + "]";
	}
	
	
	
	
}
