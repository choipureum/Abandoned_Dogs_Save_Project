package user.dog.dto;

import java.util.Date;

public class Dog_Data {
	//dog DTO
		private int dogno;
		private String dogname;
		private String dogkind;
		private String doggender;
		private String dogneu;
		private Date dogdate;
		private String dogimg;
		private int shelterno;
		//파일DTo
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
		@Override
		public String toString() {
			return "Dog_Data [dogno=" + dogno + ", dogname=" + dogname + ", dogkind=" + dogkind + ", doggender="
					+ doggender + ", dogneu=" + dogneu + ", dogdate=" + dogdate + ", dogimg=" + dogimg + ", shelterno="
					+ shelterno + ", dog_fileno=" + dog_fileno + ", dog_org_file_name=" + dog_org_file_name
					+ ", dog_stored_file_name=" + dog_stored_file_name + ", dog_file_size=" + dog_file_size
					+ ", dog_del_gb=" + dog_del_gb + "]";
		}
		public String getDogname() {
			return dogname;
		}
		public void setDogname(String dogname) {
			this.dogname = dogname;
		}
		public String getDogkind() {
			return dogkind;
		}
		public void setDogkind(String dogkind) {
			this.dogkind = dogkind;
		}
		public String getDoggender() {
			return doggender;
		}
		public void setDoggender(String doggender) {
			this.doggender = doggender;
		}
		public String getDogneu() {
			return dogneu;
		}
		public void setDogneu(String dogneu) {
			this.dogneu = dogneu;
		}
		public Date getDogdate() {
			return dogdate;
		}
		public void setDogdate(Date dogdate) {
			this.dogdate = dogdate;
		}
		public String getDogimg() {
			return dogimg;
		}
		public void setDogimg(String dogimg) {
			this.dogimg = dogimg;
		}
		public int getShelterno() {
			return shelterno;
		}
		public void setShelterno(int shelterno) {
			this.shelterno = shelterno;
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
		
}
