package bank.entity;

import java.io.Serializable;

public class Status implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer status;
	//0:Success,1:Success with a message(from back-end),2:Success with a message(from front-end),
	//3:fail with a message(from back-end),4:fail with a message(from front-end)
	private String message;
	
	
	
	public Status() {
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
		return "Status [status=" + status + ", message=" + message + "]";
	}
	
	
	
}
