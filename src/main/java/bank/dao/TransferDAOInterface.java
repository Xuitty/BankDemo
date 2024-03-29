package bank.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import bank.entity.Account;
import bank.entity.Transfer;

public interface TransferDAOInterface extends JpaRepository<Transfer, Integer> {
	
	Transfer findByTid(Integer tid);
	
	ArrayList<Transfer> findBySenderAccountOrReceiverAccountOrderByOperateTimeDesc(String aaccount, String aaccount1);
	
	ArrayList<Transfer> findByVerifyEqualsAndScheduleTimeLessThanEqualAndStatussEquals(String NULL,String dateTime,Integer statuss);
	
}
