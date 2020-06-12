package user.member.dto;

import java.util.Date;

public class MemberDTO {
		
	private String userid;
	private String userpw;
	private String username;
	private int usertel;
	private String useremail;
	private String userbirth;
	private String useraddress;
	private int usergrade;
	private Date userregdate;
	
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUsertel() {
		return usertel;
	}
	public void setUsertel(int usertel) {
		this.usertel = usertel;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserbirth() {
		return userbirth;
	}
	public void setUserbirth(String userbirth) {
		this.userbirth = userbirth;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public int getUsergrade() {
		return usergrade;
	}
	public void setUsergrade(int usergrade) {
		this.usergrade = usergrade;
	}
	public Date getUserregdate() {
		return userregdate;
	}
	public void setUserregdate(Date userregdate) {
		this.userregdate = userregdate;
	}
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", usertel=" + usertel + ", useremail=" + useremail + ", userbirth=" + userbirth + ", useraddress="
				+ useraddress + ", usergrade=" + usergrade + ", userregdate=" + userregdate + "]";
	}

}
