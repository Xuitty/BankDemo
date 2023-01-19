package bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import bank.entity.Status;
import bank.entity.User;
import bank.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.SendFailedException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class RegisterController {

	@Autowired
	UserService userService;

	Gson gson = new Gson();

	@PostMapping("/registerUser")
	public Status registerUser(@RequestBody User user) {
		boolean result = false;
		Status status = new Status();
		try {
			result = userService.createUser(user);
		} catch (SendFailedException e) {
			e.printStackTrace();
			status.setStatus(3);
			status.setMessage("emailAddressError");
			return status;
		} catch (MessagingException e) {
			e.printStackTrace();
			status.setStatus(3);
			status.setMessage("emailError");
			return status;
		}
		if (result == false) {
			status.setStatus(3);
			status.setMessage("failed");
		} else {
			status.setStatus(0);
		}
		return status;

	}

	@PostMapping("/verifyUser")
	public Status verifyUser(@RequestBody User user) {
		String verify = user.getUverify();
		Status status = new Status();
		user = userService.queryUserByName(user.getUname());
		System.out.println(user);
		if (user.getUverify().equals(verify)) {
			user = userService.writeCookie(user.getUid());
			status.setStatus(1);
			status.setMessage(user.getUcookie());
			return status;
		}
		status.setStatus(3);
		status.setMessage("verifyError");
		return status;
	}
}
