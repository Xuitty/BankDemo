package bank.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "user",uniqueConstraints = {@UniqueConstraint(columnNames = "uname")})
@Component
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer uid;
	@Column
	private String uname;
	@Column
	private String upassword;
	@Column
	private String upassword_salt;
	@Column
	private String urealname;
	@Column
	private String uemail;
	@Column
	private String utelephone;
	@Column
	private String uaddress;
	@Column
	private String uidentity;
	@Column
	private Integer uactive;
	@Column
	private Integer ulevel;

	public User() {
	}

	public User(Integer uid, String uname, String upassword, String upassword_salt, String urealname, String uemail,
			String utelephone, String uaddress, String uidentity, Integer uactive, Integer ulevel) {
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.upassword_salt = upassword_salt;
		this.urealname = urealname;
		this.uemail = uemail;
		this.utelephone = utelephone;
		this.uaddress = uaddress;
		this.uidentity = uidentity;
		this.uactive = uactive;
		this.ulevel = ulevel;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUpassword_salt() {
		return upassword_salt;
	}

	public void setUpassword_salt(String upassword_salt) {
		this.upassword_salt = upassword_salt;
	}

	public String getUrealname() {
		return urealname;
	}

	public void setUrealname(String urealname) {
		this.urealname = urealname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUtelephone() {
		return utelephone;
	}

	public void setUtelephone(String utelephone) {
		this.utelephone = utelephone;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUidentity() {
		return uidentity;
	}

	public void setUidentity(String uidentity) {
		this.uidentity = uidentity;
	}

	public Integer getUactive() {
		return uactive;
	}

	public void setUactive(Integer uactive) {
		this.uactive = uactive;
	}

	public Integer getUlevel() {
		return ulevel;
	}

	public void setUlevel(Integer ulevel) {
		this.ulevel = ulevel;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", upassword_salt="
				+ upassword_salt + ", urealname=" + urealname + ", uemail=" + uemail + ", utelephone=" + utelephone
				+ ", uaddress=" + uaddress + ", uidentity=" + uidentity + ", uactive=" + uactive + ", ulevel=" + ulevel
				+ "]";
	}

}
