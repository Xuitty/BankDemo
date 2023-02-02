package bank.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Info implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid;
	private String uname;
	private Integer account;
	private Integer creditCard;
	private Integer debitCard;
	private String totalMoney;

	public Info() {
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

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Integer getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(Integer creditCard) {
		this.creditCard = creditCard;
	}

	public Integer getDebitCard() {
		return debitCard;
	}

	public void setDebitCard(Integer debitCard) {
		this.debitCard = debitCard;
	}
	

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	@Override
	public String toString() {
		return "Info [uid=" + uid + ", uname=" + uname + ", account=" + account + ", creditCard=" + creditCard
				+ ", debitCard=" + debitCard + ", totalMoney=" + totalMoney + "]";
	}


}
