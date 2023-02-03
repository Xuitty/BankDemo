package bank.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.dao.AccountDAOInterface;
import bank.entity.Account;
import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAOInterface accountDAOInterface;

	@Transactional
	@Override
	public boolean creatAccount(Account aaccount) {
		Account result = accountDAOInterface.save(aaccount);
		return result.getAaccount() == null ? false : true;
	}

	@Transactional
	@Override
	public Account queryAccount(Integer aid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public ArrayList<Account> queryAccountListByUid(Integer uid) {
		ArrayList<Account> result = accountDAOInterface.findByUid(uid);
		return result;
	}

	@Transactional
	@Override
	public Account updateAccount(Account aaccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public boolean deleteAccount(Integer aid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public Account getLastAccount() {

		Account result = accountDAOInterface.findFirstByOrderByAidDesc();
		return result;
	}

}
