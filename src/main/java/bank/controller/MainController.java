package bank.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import bank.entity.Account;
import bank.entity.Card;
import bank.entity.Info;
import bank.entity.User;
import bank.service.AccountService;
import bank.service.CardService;
import bank.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class MainController {

	@Autowired
	UserService userService;
	@Autowired
	AccountService accountService;
	@Autowired
	CardService cardService;

	Gson gson = new Gson();

	@PostMapping("/mainGetInfo")
	public Info mainGetInfo(@RequestBody User user) {
		Info info = new Info();
		user = userService.queryCookie(user.getUcookie());
		ArrayList<Account> allAccount = accountService.queryAccountListByUid(user.getUid());
		ArrayList<Card> allCreditCard = cardService.queryCardListByUid(user.getUid());
//		ArrayList<Card> debitCardCount = ;
		ArrayList<ArrayList<Card>> allDebitCard = new ArrayList<>();
		int count = 0;
		BigDecimal totalMoney=new BigDecimal(0);
		for (Account y : allAccount) {
			allDebitCard.add(cardService.queryCardListByAid(y.getAid()));
			totalMoney=totalMoney.add(y.getAbalance());
		}
		for(ArrayList<Card> y:allDebitCard) {
			count+=y.size();
		}

		info.setUid(user.getUid());
		info.setUname(user.getUname());
		info.setAccount(allAccount.size());
		info.setCreditCard(allCreditCard.size());
		info.setDebitCard(count);
		info.setTotalMoney(totalMoney);
		System.out.println(info);

		return info;
	}
}
