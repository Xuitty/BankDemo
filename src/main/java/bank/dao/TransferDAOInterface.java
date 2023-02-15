package bank.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import bank.entity.Account;
import bank.entity.Transfer;

public interface TransferDAOInterface extends JpaRepository<Transfer, Integer> {
	
	Transfer findByTid(Integer tid);
	
	ArrayList<Transfer> findByVerifyEqualsAndScheduleTimeLessThanEqualAndStatussEquals(String NULL,String dateTime,Integer statuss);
	
}
