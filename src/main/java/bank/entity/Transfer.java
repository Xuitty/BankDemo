package bank.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Transfer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer senderAid;
	private Integer receiverBankCode;
	private Integer receiverAid;
	private BigDecimal amount;
	private String amountString;
	private Integer currencyType;
	private Boolean schedule;
	private Long scheduleTime;
	private Long operateTime;
	private String verify;

	public Integer getSenderAid() {
		return senderAid;
	}

	public void setSenderAid(Integer senderAid) {
		this.senderAid = senderAid;
	}

	public Integer getReceiverBankCode() {
		return receiverBankCode;
	}

	public void setReceiverBankCode(Integer receiverBankCode) {
		this.receiverBankCode = receiverBankCode;
	}

	public Integer getReceiverAid() {
		return receiverAid;
	}

	public void setReceiverAid(Integer receiverAid) {
		this.receiverAid = receiverAid;
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

	public Long getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(Long scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Long getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Long operateTime) {
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
		return "Transfer [senderAid=" + senderAid + ", receiverBankCode=" + receiverBankCode + ", receiverAid="
				+ receiverAid + ", amount=" + amount + ", amountString=" + amountString + ", currencyType="
				+ currencyType + ", schedule=" + schedule + ", scheduleTime=" + scheduleTime + ", operateTime="
				+ operateTime + ", verify=" + verify + "]";
	}

}
