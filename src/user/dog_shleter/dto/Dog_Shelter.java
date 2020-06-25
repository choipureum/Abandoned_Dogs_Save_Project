package user.dog_shleter.dto;

public class Dog_Shelter {

	private int shelterno;
	private String sheltername;
	private String shelterlat;
	private String shelterlon;
	private String shelteraddress;
	private String sheltertel;
	public int getShelterno() {
		return shelterno;
	}
	public void setShelterno(int shelterno) {
		this.shelterno = shelterno;
	}
	public String getSheltername() {
		return sheltername;
	}
	public void setSheltername(String sheltername) {
		this.sheltername = sheltername;
	}
	public String getShelterlat() {
		return shelterlat;
	}
	public void setShelterlat(String shelterlat) {
		this.shelterlat = shelterlat;
	}
	public String getShelterlon() {
		return shelterlon;
	}
	public void setShelterlon(String shelterlon) {
		this.shelterlon = shelterlon;
	}
	public String getShelteraddress() {
		return shelteraddress;
	}
	public void setShelteraddress(String shelteraddress) {
		this.shelteraddress = shelteraddress;
	}
	public String getSheltertel() {
		return sheltertel;
	}
	public void setSheltertel(String sheltertel) {
		this.sheltertel = sheltertel;
	}
	@Override
	public String toString() {
		return "Dog_Shelter [shelterno=" + shelterno + ", sheltername=" + sheltername + ", shelterlat=" + shelterlat
				+ ", shelterlon=" + shelterlon + ", shelteraddress=" + shelteraddress + ", sheltertel=" + sheltertel
				+ "]";
	}
	
	
	
}
