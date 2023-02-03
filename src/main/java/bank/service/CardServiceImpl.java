package bank.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.dao.CardDAOInterface;
import bank.entity.Card;
import jakarta.transaction.Transactional;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardDAOInterface cardDAOInterface;

	@Transactional
	@Override
	public boolean createCard(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public Card queryCard(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public ArrayList<Card> queryCardListByUid(Integer uid) {
		ArrayList<Card> result = cardDAOInterface.findByUid(uid);
		return result;
	}

	@Transactional
	@Override
	public ArrayList<Card> queryCardListByAid(Integer aid) {
		ArrayList<Card> result = cardDAOInterface.findByAid(aid);
		return result;
	}

	@Transactional
	@Override
	public Card updateCard(Card card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public boolean deleteCard(Integer cid) {
		// TODO Auto-generated method stub
		return false;
	}

}
