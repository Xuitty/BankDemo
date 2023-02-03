package bank.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import bank.entity.User;
import jakarta.transaction.Transactional;

public interface UserDAOInterface extends JpaRepository<User, Integer> {
	
	User findByUid(Integer uid);
	
	User findByUname(String uname);
	
	User findByUcookie(String ucookie);
	
	ArrayList<User> findByLasttimeLessThan(Long currentTime);
//	@Transactional
//	@Modifying
//	@Query(value = "CREATE EVENT test ON SCHEDULE AT current_timestamp() + interval 10 second on completion not preserve DO UPDATE user SET uactive=5 WHERE uid = 1",nativeQuery = true)
//	void scheduleDeleteCookie();
}
