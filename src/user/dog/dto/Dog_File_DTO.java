package user.dog.dto;



public class Dog_File_DTO {
	private int dogno;
	private int dog_fileno;
	private String dog_org_file_name;
	private String dog_stored_file_name;
	private int dog_file_size;
	private String dog_del_gb;
	public int getDogno() {
		return dogno;
	}
	public void setDogno(int dogno) {
		this.dogno = dogno;
	}
	public int getDog_fileno() {
		return dog_fileno;
	}
	public void setDog_fileno(int dog_fileno) {
		this.dog_fileno = dog_fileno;
	}
	public String getDog_org_file_name() {
		return dog_org_file_name;
	}
	public void setDog_org_file_name(String dog_org_file_name) {
		this.dog_org_file_name = dog_org_file_name;
	}
	public String getDog_stored_file_name() {
		return dog_stored_file_name;
	}
	public void setDog_stored_file_name(String dog_stored_file_name) {
		this.dog_stored_file_name = dog_stored_file_name;
	}
	public int getDog_file_size() {
		return dog_file_size;
	}
	public void setDog_file_size(int dog_file_size) {
		this.dog_file_size = dog_file_size;
	}
	public String getDog_del_gb() {
		return dog_del_gb;
	}
	public void setDog_del_gb(String dog_del_gb) {
		this.dog_del_gb = dog_del_gb;
	}
	@Override
	public String toString() {
		return "Dog_File_DTO [dogno=" + dogno + ", dog_fileno=" + dog_fileno + ", dog_org_file_name="
				+ dog_org_file_name + ", dog_stored_file_name=" + dog_stored_file_name + ", dog_file_size="
				+ dog_file_size + ", dog_del_gb=" + dog_del_gb + "]";
	}
}
