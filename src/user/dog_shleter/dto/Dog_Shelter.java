package user.dog_shleter.dto;

import user.dog.dto.DogDTO;

/**
 * @author User
 *
 */
public class Dog_Shelter {

	private int shelterno;
	private String sheltername;
	private int shelterlat;
	private int shelterlon;
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
	public int getShelterlat() {
		return shelterlat;
	}
	public void setShelterlat(int shelterlat) {
		this.shelterlat = shelterlat;
	}
	public int getShelterlon() {
		return shelterlon;
	}
	public void setShelterlon(int shelterlon) {
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
