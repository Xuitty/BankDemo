package bank.service;

import java.util.ArrayList;

import bank.entity.Account;
import bank.entity.Status;
import bank.entity.Transfer;

public interface TransferService {
	
	public Transfer createTransfer(Transfer transfer);
	
	public Transfer queryTransfer(Integer tid);
	
	public Transfer[] queryTransferByAccount(Account account);
	
	public Transfer updateTransfer(Transfer transfer);
	
	public boolean deleteTransfer(Integer tid);
	
	public Status excuteTransfer(Integer tid);
	
	public ArrayList<Status> excuteScheduleTransfer(String dateTime);
}
