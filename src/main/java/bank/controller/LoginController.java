package bank.controller;

import java.math.BigDecimal;

import bank.tools.MD5Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.entity.Account;
import bank.entity.Status;
import bank.entity.User;
import bank.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class LoginController {

	@Autowired
	UserService userService;

	@PostMapping("userLogin")
	public Status createAccount(@RequestBody User user) {
		String password = user.getUpassword();
		user = userService.queryUserByName(user.getUname());
		Status result = new Status();
		if (user == null || userService.checkUserPass(user, password) == false) {
			result.setStatuss(3);
			result.setMessage("accPassError");
			return result;
		} else if (user.getUactive() == 0) {
			result.setStatuss(3);
			result.setMessage("verifyError");
			return result;
		}

		result.setStatuss(1);
		result.setMessage(userService.writeCookie(user.getUid()).getUcookie());
		return result;
	}
}
