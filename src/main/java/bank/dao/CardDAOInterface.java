package bank.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.entity.Card;

public interface CardDAOInterface extends JpaRepository<Card, Integer> {

	ArrayList<Card> findByUid(Integer uid);

	ArrayList<Card> findByAid(Integer aid);
}
