package bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.entity.User;
public interface UserDAOInterface extends JpaRepository<User, Integer> {

}
