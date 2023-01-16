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
@Table(name = "account",uniqueConstraints = {@UniqueConstraint(columnNames = "aaccount")})
@Component
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer aid;
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

	public Account(Integer aid, String aacount, BigDecimal abalance, Integer aactive, Integer uid) {
		this.aid = aid;
		this.aaccount = aacount;
		this.abalance = abalance;
		this.aactive = aactive;
		this.uid = uid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAacount() {
		return aaccount;
	}

	public void setAacount(String aacount) {
		this.aaccount = aacount;
	}

	public BigDecimal getAbalance() {
		return abalance;
	}

	public void setAbalance(BigDecimal abalance) {
		this.abalance = abalance;
	}

	public int getAactive() {
		return aactive;
	}

	public void setAactive(int aactive) {
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
		return "Account [aid=" + aid + ", aaccount=" + aaccount + ", abalance=" + abalance + ", aactive=" + aactive
				+ ", uid=" + uid + "]";
	}

}
