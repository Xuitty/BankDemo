package bank.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bank.entity.User;
import bank.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class CookieController {
	@Autowired
	UserService userService;
	
	@PostMapping("/renewCookieTime")
	public User renewCookieTime(@RequestBody User user) {
		user=userService.queryUser(user.getUid());
		user.setLasttime(new Date().getTime()+600L*1000L);
		userService.renewCookieTime(user);
		return user;
	}
	
	@PostMapping("/renewCookieTimeUid")
	public User renewCookieTimeUid(@RequestBody Integer uid) {
		User user=userService.queryUser(uid);
		user.setLasttime(new Date().getTime()+600L*1000L);
		userService.renewCookieTime(user);
		return user;
	}
	
	@GetMapping("/checkCookieExpired")
	public boolean checkCookieExpired(@RequestParam String cookie) {
		System.out.println(cookie);
		return userService.queryCookie(cookie)==null?false:true;
		
	}
}
