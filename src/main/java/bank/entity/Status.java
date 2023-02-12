package bank.entity;

import java.io.Serializable;

public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer statuss;
	// 0:Success,1:Success with a message(from back-end),2:Success with a
	// message(from front-end),
	// 3:fail with a message(from back-end),4:fail with a message(from front-end)
	private Integer errorCode;
	private String message;

	public Status() {
	}

	public Integer getStatuss() {
		return statuss;
	}

	public void setStatuss(Integer statuss) {
		this.statuss = statuss;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Status [statuss=" + statuss + ", errorCode=" + errorCode + ", message=" + message + "]";
	}

}
