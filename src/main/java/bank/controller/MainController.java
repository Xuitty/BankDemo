package bank.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import bank.entity.Account;
import bank.entity.Card;
import bank.entity.Info;
import bank.entity.InfoString;
import bank.entity.Status;
import bank.entity.User;
import bank.service.AccountService;
import bank.service.CardService;
import bank.service.UserService;
import bank.tools.AccountUtils;
import bank.tools.InfoDecimal2StringConverter;
import bank.tools.JavaMailTools;
import bank.tools.PasswordGenerator;
import jakarta.mail.MessagingException;
import jakarta.mail.SendFailedException;

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
	AccountUtils accountUtils = new AccountUtils();
	JavaMailTools javaMailTools = new JavaMailTools();

	@PostMapping("/mainGetInfo")
	public InfoString mainGetInfo(@RequestBody User user) {
		Info info = new Info();
		user = userService.queryCookie(user.getUcookie());
		if (user == null) {
			return null;
		}
		ArrayList<Account> allAccount = accountService.queryAccountListByUid(user.getUid());
		ArrayList<Account> allActivedAccount = new ArrayList<>();
		ArrayList<Card> allCreditCard = cardService.queryCardListByUid(user.getUid());
		ArrayList<Card> allActivedCreditCard = new ArrayList<>();
		for (Card y : allCreditCard) {
			if (y.getCactive() == 1) {
				allActivedCreditCard.add(y);
			}
		}
		ArrayList<ArrayList<Card>> allAccountDebitCard = new ArrayList<>();
		ArrayList<Card> allDebitCard = new ArrayList<>();
		ArrayList<Card> allActivedDebitCard = new ArrayList<>();
		BigDecimal totalMoney = new BigDecimal(0);
		for (Account y : allAccount) {
			if (y.getAactive() == 1) {
				allActivedAccount.add(y);
			}
			allAccountDebitCard.add(cardService.queryCardListByAid(y.getAid()));
			totalMoney = totalMoney.add(y.getAbalance());
		}
		for (ArrayList<Card> y : allAccountDebitCard) {
			if (y.size() > 0) {
				for (Card z : y) {
					allDebitCard.add(z);
					if (z.getCactive() == 1) {
						allActivedDebitCard.add(z);
					}
				}
			}
		}

		
		
		info.setUid(user.getUid());
		info.setUname(user.getUname());
		info.setAllAccount(allAccount.toArray(new Account[allAccount.size()]));
		info.setAllActivedAccount(allActivedAccount.toArray(new Account[allActivedAccount.size()]));
		info.setAllCreditCard(allCreditCard.toArray(new Card[allCreditCard.size()]));
		info.setAllActivedCreditCard(allActivedCreditCard.toArray(new Card[allActivedCreditCard.size()]));
		info.setAllDebitCard(allDebitCard.toArray(new Card[allDebitCard.size()]));
		info.setAllActivedDebitCard(allActivedDebitCard.toArray(new Card[allActivedDebitCard.size()]));
		info.setTotalMoney(totalMoney.toString());
		info.setLasttime(new Date().getTime());
		System.out.println(info);
		System.out.println(InfoDecimal2StringConverter.receiver(info));
		
		return InfoDecimal2StringConverter.receiver(info);
	}

	@PostMapping("createAccount")
	public Status createAccount(@RequestBody Account account) {
		System.out.println(account);
		Status result = new Status();
		account.setAactive(0);
		account.setAbalance(new BigDecimal(0));
		String verify = new PasswordGenerator().verifyGen(6);
		account.setAverify(verify);
		Integer aid = null;
		try {
			account.setAaccount(accountUtils.generator(accountService.getLastAccount()));
			aid = accountService.creatAccount(account).getAid();
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatuss(3);
			result.setMessage("Unknowed Error");
			return result;
		}
		try {
			javaMailTools.sendVerify("金發財商業銀行戶頭註冊驗證碼",
					userService.queryUser(accountService.queryAccount(aid).getUid()).getUrealname(),
					userService.queryUser(accountService.queryAccount(aid).getUid()).getUemail(), verify);
		} catch (SendFailedException e) {
//			e.printStackTrace();
			System.out.println("emailError");
			result.setStatuss(3);
			result.setMessage("emailAddressError");
			return result;
		} catch (MessagingException e) {
			e.printStackTrace();
			result.setStatuss(3);
			result.setMessage("emailError");
			return result;
		}
		result.setStatuss(1);
		result.setMessage(String.valueOf(aid));
		return result;
	}

	@PostMapping("verifyAccount")
	public Status verifyAccount(@RequestBody Account account) {
		Status result = new Status();
		Account account_new = accountService.queryAccount(account.getAid());
		if (!(account_new.getAverify().equals(account.getAverify()))) {
			result.setStatuss(3);
			result.setMessage("verifyError");
			return result;
		}
		account_new.setAverify(null);
		account_new.setAactive(2);
		accountService.updateAccount(account_new);
		result.setStatuss(0);
		return result;
	}

}
