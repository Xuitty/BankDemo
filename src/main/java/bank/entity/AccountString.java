package bank.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "account", uniqueConstraints = { @UniqueConstraint(columnNames = "aaccount") })
@Component
public class AccountString implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer aid;
	@Column
	private Integer atype = 1;
	@Column
	private String aaccount;
	@Column
	private String abalance;
	@Column
	private Integer aactive;
	@Column
	private String averify;
	@Column
	private String anickname;
	@Column
	private Integer uid;

	private Integer statuss;
	private String message;

	public AccountString() {
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getAtype() {
		return atype;
	}

	public void setAtype(Integer atype) {
		this.atype = atype;
	}

	public String getAaccount() {
		return aaccount;
	}

	public void setAaccount(String aaccount) {
		this.aaccount = aaccount;
	}

	public String getAbalance() {
		return abalance;
	}

	public void setAbalance(String abalance) {
		this.abalance = abalance;
	}

	public Integer getAactive() {
		return aactive;
	}

	public void setAactive(Integer aactive) {
		this.aactive = aactive;
	}

	public String getAverify() {
		return averify;
	}

	public void setAverify(String averify) {
		this.averify = averify;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getStatuss() {
		return statuss;
	}

	public void setStatuss(Integer statuss) {
		this.statuss = statuss;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAnickname() {
		return anickname;
	}

	public void setAnickname(String anickname) {
		this.anickname = anickname;
	}

	@Override
	public String toString() {
		return "AccountString [aid=" + aid + ", atype=" + atype + ", aaccount=" + aaccount + ", abalance=" + abalance
				+ ", aactive=" + aactive + ", averify=" + averify + ", anickname=" + anickname + ", uid=" + uid
				+ ", statuss=" + statuss + ", message=" + message + "]";
	}

}
