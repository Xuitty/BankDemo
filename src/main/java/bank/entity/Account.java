package bank.entity;

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
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer aid;
	@Column
	private String atype;
	@Column
	private String aaccount;
	@Column
	private BigDecimal abalance;
	@Column
	private Integer aactive;
	@Column
	private Integer uid;

	public Account() {
	}

	public Account(Integer aid, String atype, String aaccount, BigDecimal abalance, Integer aactive, Integer uid) {
		super();
		this.aid = aid;
		this.atype = atype;
		this.aaccount = aaccount;
		this.abalance = abalance;
		this.aactive = aactive;
		this.uid = uid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public String getAaccount() {
		return aaccount;
	}

	public void setAaccount(String aaccount) {
		this.aaccount = aaccount;
	}

	public BigDecimal getAbalance() {
		return abalance;
	}

	public void setAbalance(BigDecimal abalance) {
		this.abalance = abalance;
	}

	public Integer getAactive() {
		return aactive;
	}

	public void setAactive(Integer aactive) {
		this.aactive = aactive;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", atype=" + atype + ", aaccount=" + aaccount + ", abalance=" + abalance
				+ ", aactive=" + aactive + ", uid=" + uid + "]";
	}

	

}
