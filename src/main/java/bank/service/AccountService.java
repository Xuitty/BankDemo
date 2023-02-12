package bank.service;

import java.util.ArrayList;

import bank.entity.Account;

public interface AccountService {

	Account creatAccount(Account aaccount);

	Account queryAccount(Integer aid);
	
	Account queryAccountByAaccount(String Aaccount);

	ArrayList<Account> queryAccountListByUid(Integer uid);
	
	Account getLastAccount();

	Account updateAccount(Account aaccount);

	boolean deleteAccount(Integer aid);
}
