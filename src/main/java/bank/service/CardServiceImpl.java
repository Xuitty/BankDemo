package bank.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.dao.CardDAOInterface;
import bank.entity.Card;
@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	CardDAOInterface cardDAOInterface;

	@Override
	public boolean createCard(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Card queryCard(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Card> queryCardListByUid(Integer uid) {
		ArrayList<Card> result = cardDAOInterface.findByUid(uid);
		return result;
	}

	@Override
	public ArrayList<Card> queryCardListByAid(Integer aid) {
		ArrayList<Card> result = cardDAOInterface.findByAid(aid);
		return result;
	}

	@Override
	public Card updateCard(Card card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCard(Integer cid) {
		// TODO Auto-generated method stub
		return false;
	}

}
