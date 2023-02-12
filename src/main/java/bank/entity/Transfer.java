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
	@Column
	private String sender_account;
	@Column
	private Integer receiver_bank_code;
	@Column
	private String receiver_account;
	@Column
	private BigDecimal amount;
	@Transient
	private String amount_string;
	@Column
	private Integer currency_type;
	@Column
	private Boolean schedule;
	@Column
	private Long schedule_time;
	@Column
	private Long operate_time;
	@Column
	private String verify;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getSender_account() {
		return sender_account;
	}

	public void setSender_account(String sender_account) {
		this.sender_account = sender_account;
	}

	public Integer getReceiver_bank_code() {
		return receiver_bank_code;
	}

	public void setReceiver_bank_code(Integer receiver_bank_code) {
		this.receiver_bank_code = receiver_bank_code;
	}

	public String getReceiver_account() {
		return receiver_account;
	}

	public void setReceiver_account(String receiver_account) {
		this.receiver_account = receiver_account;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAmount_string() {
		return amount_string;
	}

	public void setAmount_string(String amount_string) {
		this.amount_string = amount_string;
	}

	public Integer getCurrency_type() {
		return currency_type;
	}

	public void setCurrency_type(Integer currency_type) {
		this.currency_type = currency_type;
	}

	public Boolean getSchedule() {
		return schedule;
	}

	public void setSchedule(Boolean schedule) {
		this.schedule = schedule;
	}

	public Long getSchedule_time() {
		return schedule_time;
	}

	public void setSchedule_time(Long schedule_time) {
		this.schedule_time = schedule_time;
	}

	public Long getOperate_time() {
		return operate_time;
	}

	public void setOperate_time(Long operate_time) {
		this.operate_time = operate_time;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	@Override
	public String toString() {
		return "Transfer [tid=" + tid + ", sender_account=" + sender_account + ", receiver_bank_code="
				+ receiver_bank_code + ", receiver_account=" + receiver_account + ", amount=" + amount
				+ ", amount_string=" + amount_string + ", currency_type=" + currency_type + ", schedule=" + schedule
				+ ", schedule_time=" + schedule_time + ", operate_time=" + operate_time + ", verify=" + verify + "]";
	}

}
