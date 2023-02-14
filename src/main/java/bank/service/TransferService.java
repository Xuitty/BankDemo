package bank.service;

import java.util.ArrayList;

import bank.entity.Transfer;

public interface TransferService {
	
	public Transfer createTransfer(Transfer transfer);
	
	public Transfer queryTransfer(Integer tid);
	
	public Transfer updateTransfer(Transfer transfer);
	
	public boolean deleteTransfer(Integer tid);
	
	public ArrayList<Transfer> excuteScheduleTransfer(String dateTime);
}
