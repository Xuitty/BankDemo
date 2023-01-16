package bank.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.dao.AccountDAOInterface;
import bank.dao.CardDAOInterface;
import bank.dao.UserDAOInterface;
import bank.entity.Account;
import bank.entity.Card;
import bank.entity.User;
import bank.tools.PasswordGenerator;

@RestController
public class TestController {

	@Autowired
	AccountDAOInterface accountDAOInterface;
	@Autowired
	CardDAOInterface cardDAOInterface;
	@Autowired
	UserDAOInterface userDAOInterface;

	@GetMapping("/")
	public String test() {
		Account account = new Account(null, "123456123456", new BigDecimal(22.3300), 1, 53);
		Card card = new Card(null, "1234561234561234", "2022/06", "123", new PasswordGenerator().saltGen(32), 0, 1, 1);
		User user = new User(1, "John Doe", "123456",null , "王八", "A123456789", "0912345678", "台灣特別行政區天龍市維尼路88號", "test@test.org", 1, 1);
		account = accountDAOInterface.save(account);
		card= cardDAOInterface.save(card);
		user= userDAOInterface.save(user);
//		System.out.println(account.getAbalance().setScale(4,RoundingMode.HALF_UP));
		
		return account+"<br><br>"+card+"<br><br>"+user;
	}
}
