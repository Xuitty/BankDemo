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
@Table(name = "card", uniqueConstraints = { @UniqueConstraint(columnNames = "cnumber") })
@Component
public class Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer cid;
	@Column
	private Integer ctype = 1;
	@Column
	private String cnumber;
	@Column
	private String cdate;
	@Column
	private String cccv;
	@Column
	private String cccv_salt;
	@Column
	private Integer cacitve = 0;
	@Column
	private BigDecimal ccurrent;
	@Column
	private BigDecimal climit;
	@Column
	private Integer cfailed = 0;
	@Column
	private String cverify;
	@Column
	private Integer aid;
	@Column
	private Integer uid;

	private Integer statuss;
	private String message;

	public Card() {
	}

	public Card(Integer cid, Integer ctype, String cnumber, String cdate, String cccv, String cccv_salt,
			Integer cacitve, BigDecimal ccurrent, BigDecimal climit, Integer cfailed, Integer aid, Integer uid) {
		this.cid = cid;
		this.ctype = ctype;
		this.cnumber = cnumber;
		this.cdate = cdate;
		this.cccv = cccv;
		this.cccv_salt = cccv_salt;
		this.cacitve = cacitve;
		this.ccurrent = ccurrent;
		this.climit = climit;
		this.cfailed = cfailed;
		this.aid = aid;
		this.uid = uid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCtype() {
		return ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	public String getCnumber() {
		return cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getCccv() {
		return cccv;
	}

	public void setCccv(String cccv) {
		this.cccv = cccv;
	}

	public String getCccv_salt() {
		return cccv_salt;
	}

	public void setCccv_salt(String cccv_salt) {
		this.cccv_salt = cccv_salt;
	}

	public Integer getCacitve() {
		return cacitve;
	}

	public void setCacitve(Integer cacitve) {
		this.cacitve = cacitve;
	}

	public BigDecimal getCcurrent() {
		return ccurrent;
	}

	public void setCcurrent(BigDecimal ccurrent) {
		this.ccurrent = ccurrent;
	}

	public BigDecimal getClimit() {
		return climit;
	}

	public void setClimit(BigDecimal climit) {
		this.climit = climit;
	}

	public Integer getCfailed() {
		return cfailed;
	}

	public void setCfailed(Integer cfailed) {
		this.cfailed = cfailed;
	}

	public String getCverify() {
		return cverify;
	}

	public void setCverify(String cverify) {
		this.cverify = cverify;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
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

	@Override
	public String toString() {
		return "Card [cid=" + cid + ", ctype=" + ctype + ", cnumber=" + cnumber + ", cdate=" + cdate + ", cccv=" + cccv
				+ ", cccv_salt=" + cccv_salt + ", cacitve=" + cacitve + ", ccurrent=" + ccurrent + ", climit=" + climit
				+ ", cfailed=" + cfailed + ", cverify=" + cverify + ", aid=" + aid + ", uid=" + uid + ", statuss="
				+ statuss + ", message=" + message + "]";
	}

}
