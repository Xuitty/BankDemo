package bank.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.dao.AccountDAOInterface;
import bank.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAOInterface accountDAOInterface;

	@Override
	public boolean creatAccount(Account aaccount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account queryAccount(Integer aid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Account> queryAccountListByUid(Integer uid) {
		ArrayList<Account> result = accountDAOInterface.findByUid(uid);
		return result;
	}

	@Override
	public Account updateAccount(Account aaccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAccount(Integer aid) {
		// TODO Auto-generated method stub
		return false;
	}

}
