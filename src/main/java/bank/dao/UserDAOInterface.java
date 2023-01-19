package bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.entity.User;

public interface UserDAOInterface extends JpaRepository<User, Integer> {
	
	User findByUid(Integer uid);
	
	User findByUname(String uname);
	
	User findByUcookie(String ucookie);
}
