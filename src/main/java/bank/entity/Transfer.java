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
import jakarta.persistence.Transient;

@Entity
@Table(name = "transfer")
@Component
public class Transfer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer tid;
	@Column(name = "sender_account")
	private String senderAccount;
	@Column(name = "receiver_bank_code")
	private Integer receiverBankCode;
	@Column(name = "receiver_account")
	private String receiverAccount;
	@Column
	private BigDecimal amount;
	@Transient
	private String amountString;
	@Column(name = "currency_type")
	private Integer currencyType;
	@Column
	private Boolean schedule;
	@Column(name = "schedule_time")
	private String scheduleTime;
	@Column(name = "operate_time")
	private String operateTime;
	@Column
	private String verify;
	
	

	public Transfer() {
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(String senderAccount) {
		this.senderAccount = senderAccount;
	}

	public Integer getReceiverBankCode() {
		return receiverBankCode;
	}

	public void setReceiverBankCode(Integer receiverBankCode) {
		this.receiverBankCode = receiverBankCode;
	}

	public String getReceiverAccount() {
		return receiverAccount;
	}

	public void setReceiverAccount(String receiverAccount) {
		this.receiverAccount = receiverAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAmountString() {
		return amountString;
	}

	public void setAmountString(String amountString) {
		this.amountString = amountString;
	}

	public Integer getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(Integer currencyType) {
		this.currencyType = currencyType;
	}

	public Boolean getSchedule() {
		return schedule;
	}

	public void setSchedule(Boolean schedule) {
		this.schedule = schedule;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	@Override
	public String toString() {
		return "Transfer [tid=" + tid + ", senderAccount=" + senderAccount + ", receiverBankCode=" + receiverBankCode
				+ ", receiverAccount=" + receiverAccount + ", amount=" + amount + ", amountString=" + amountString
				+ ", currencyType=" + currencyType + ", schedule=" + schedule + ", scheduleTime=" + scheduleTime
				+ ", operateTime=" + operateTime + ", verify=" + verify + "]";
	}

}
