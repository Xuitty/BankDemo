package bank.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class InfoString implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid;
	private String uname;
	private AccountString[] allAccount;
	private AccountString[] allActivedAccount;
	private CardString[] allCreditCard;
	private CardString[] allActivedCreditCard;
	private CardString[] allDebitCard;
	private CardString[] allActivedDebitCard;
	private String totalMoney;
	private Long lasttime = -1L;

	public InfoString() {
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

	public AccountString[] getAllAccount() {
		return allAccount;
	}

	public void setAllAccount(AccountString[] allAccount) {
		this.allAccount = allAccount;
	}

	public AccountString[] getAllActivedAccount() {
		return allActivedAccount;
	}

	public void setAllActivedAccount(AccountString[] allActivedAccount) {
		this.allActivedAccount = allActivedAccount;
	}

	public CardString[] getAllCreditCard() {
		return allCreditCard;
	}

	public void setAllCreditCard(CardString[] allCreditCard) {
		this.allCreditCard = allCreditCard;
	}

	public CardString[] getAllActivedCreditCard() {
		return allActivedCreditCard;
	}

	public void setAllActivedCreditCard(CardString[] allActivedCreditCard) {
		this.allActivedCreditCard = allActivedCreditCard;
	}

	public CardString[] getAllDebitCard() {
		return allDebitCard;
	}

	public void setAllDebitCard(CardString[] allDebitCard) {
		this.allDebitCard = allDebitCard;
	}

	public CardString[] getAllActivedDebitCard() {
		return allActivedDebitCard;
	}

	public void setAllActivedDebitCard(CardString[] allActivedDebitCard) {
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
