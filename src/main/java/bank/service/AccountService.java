package bank.service;

import java.util.ArrayList;

import bank.entity.Account;

public interface AccountService {

	boolean creatAccount(Account aaccount);

	Account queryAccount(Integer aid);

	ArrayList<Account> queryAccountListByUid(Integer uid);
	
	Account getLastAccount();

	Account updateAccount(Account aaccount);

	boolean deleteAccount(Integer aid);
}
