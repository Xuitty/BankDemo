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
public class RegisterController {

	@Autowired
	AccountDAOInterface accountDAOInterface;
	@Autowired
	CardDAOInterface cardDAOInterface;
	@Autowired
	UserDAOInterface userDAOInterface;

	@GetMapping("/")
	public String test() {
	}
}
