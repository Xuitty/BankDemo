package bank.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.entity.Account;

public interface AccountDAOInterface extends JpaRepository<Account, Integer> {
	
	ArrayList<Account> findByUid(Integer uid);
	
	Account findByAid(Integer aid);
	
	Account findByAaccount(String aaccount);
	
	Account findFirstByOrderByAidDesc();
	
	
	
}
