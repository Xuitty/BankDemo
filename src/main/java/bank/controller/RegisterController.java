package bank.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import bank.dao.AccountDAOInterface;
import bank.dao.CardDAOInterface;
import bank.dao.UserDAOInterface;
import bank.entity.Account;
import bank.entity.Card;
import bank.entity.User;
import bank.service.UserService;
import bank.tools.PasswordGenerator;
import jakarta.mail.SendFailedException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class RegisterController {

	@Autowired
	UserService userService;

	Gson gson = new Gson();

	@PostMapping("/registerUser")
	public String registerUser(@RequestBody User user) {
		System.out.println(user);
		boolean result=false;
		try {
			result = userService.createUser(user);
		} catch (SendFailedException e) {
			e.printStackTrace();
			System.out.println("mailfailed");
			return "emailError";
		}

		return result == true ? "success" : "failed";
	}

	@PostMapping("/verifyUser")
	public User verifyUser(@RequestBody User user) {
		String verify = userService.queryUserByName(user.getUname()).getUverify();
		if(user.getUverify().equals(verify)) {
			user=userService.writeCookie(user.getUid());
			return user;
		}
		return new User();
	}
}
