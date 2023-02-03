package bank.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "uname") })
@Component
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private String usex;
	@Column
	private String udate;
	@Column
	private String uidentity;
	@Column
	private Integer uactive = 0;
	@Column
	private Integer ulevel = 0;
	@Column
	private String ucookie;
	@Column
	private String ucookie_salt;
	@Column
	private String uverify;

	private Integer status;
	private String message;

	@Column
	private Long lasttime=-1L;

	public User() {
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

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUdate() {
		return udate;
	}

	public void setUdate(String udate) {
		this.udate = udate;
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

	public String getUcookie() {
		return ucookie;
	}

	public void setUcookie(String ucookie) {
		this.ucookie = ucookie;
	}

	public String getUcookie_salt() {
		return ucookie_salt;
	}

	public void setUcookie_salt(String ucookie_salt) {
		this.ucookie_salt = ucookie_salt;
	}

	public String getUverify() {
		return uverify;
	}

	public void setUverify(String uverify) {
		this.uverify = uverify;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getLasttime() {
		return lasttime;
	}

	public void setLasttime(Long lasttime) {
		this.lasttime = lasttime;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", upassword_salt="
				+ upassword_salt + ", urealname=" + urealname + ", uemail=" + uemail + ", utelephone=" + utelephone
				+ ", uaddress=" + uaddress + ", usex=" + usex + ", udate=" + udate + ", uidentity=" + uidentity
				+ ", uactive=" + uactive + ", ulevel=" + ulevel + ", ucookie=" + ucookie + ", ucookie_salt="
				+ ucookie_salt + ", uverify=" + uverify + ", status=" + status + ", message=" + message + ", lasttime="
				+ lasttime + "]";
	}

}
