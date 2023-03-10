package bank.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Info implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid;
	private String uname;
	private Account[] allAccount;
	private Account[] allActivedAccount;
	private Card[] allCreditCard;
	private Card[] allActivedCreditCard;
	private Card[] allDebitCard;
	private Card[] allActivedDebitCard;
	private String totalMoney;
	private Long lasttime = -1L;

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

	public Account[] getAllAccount() {
		return allAccount;
	}

	public void setAllAccount(Account[] allAccount) {
		this.allAccount = allAccount;
	}

	public Account[] getAllActivedAccount() {
		return allActivedAccount;
	}

	public void setAllActivedAccount(Account[] allActivedAccount) {
		this.allActivedAccount = allActivedAccount;
	}

	public Card[] getAllCreditCard() {
		return allCreditCard;
	}

	public void setAllCreditCard(Card[] allCreditCard) {
		this.allCreditCard = allCreditCard;
	}

	public Card[] getAllActivedCreditCard() {
		return allActivedCreditCard;
	}

	public void setAllActivedCreditCard(Card[] allActivedCreditCard) {
		this.allActivedCreditCard = allActivedCreditCard;
	}

	public Card[] getAllDebitCard() {
		return allDebitCard;
	}

	public void setAllDebitCard(Card[] allDebitCard) {
		this.allDebitCard = allDebitCard;
	}

	public Card[] getAllActivedDebitCard() {
		return allActivedDebitCard;
	}

	public void setAllActivedDebitCard(Card[] allActivedDebitCard) {
		this.allActivedDebitCard = allActivedDebitCard;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Long getLasttime() {
		return lasttime;
	}

	public void setLasttime(Long lasttime) {
		this.lasttime = lasttime;
	}

	@Override
	public String toString() {
		return "Info [uid=" + uid + ", uname=" + uname + ", allAccount=" + Arrays.toString(allAccount)
				+ ", allActivedAccount=" + Arrays.toString(allActivedAccount) + ", allCreditCard="
				+ Arrays.toString(allCreditCard) + ", allActivedCreditCard=" + Arrays.toString(allActivedCreditCard)
				+ ", allDebitCard=" + Arrays.toString(allDebitCard) + ", allActivedDebitCard="
				+ Arrays.toString(allActivedDebitCard) + ", totalMoney=" + totalMoney + ", lasttime=" + lasttime + "]";
	}

}
