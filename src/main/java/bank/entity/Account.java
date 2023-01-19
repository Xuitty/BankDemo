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
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer aid;
	@Column
	private Integer atype=1;
	@Column
	private String aaccount;
	@Column
	private BigDecimal abalance;
	@Column
	private Integer aactive;
	@Column
	private Integer uid;
	
	private Integer status;
	private String message;

	public Account() {
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

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", atype=" + atype + ", aaccount=" + aaccount + ", abalance=" + abalance
				+ ", aactive=" + aactive + ", uid=" + uid + ", status=" + status + ", message=" + message + "]";
	}


	

}
