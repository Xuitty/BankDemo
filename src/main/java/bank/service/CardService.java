package bank.service;

import java.util.ArrayList;

import bank.entity.Card;

public interface CardService {

	boolean createCard(Card card);

	Card queryCard(Integer cid);

	ArrayList<Card> queryCardListByUid(Integer uid);

	ArrayList<Card> queryCardListByAid(Integer aid);

	Card updateCard(Card card);

	boolean deleteCard(Integer cid);
}
