package bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.entity.Card;
public interface CardDAOInterface extends JpaRepository<Card, Integer> {

}
