package bank.service;

import java.util.ArrayList;

import bank.entity.User;
import jakarta.mail.MessagingException;

public interface UserService {
	
	public boolean createUser(User user) throws MessagingException;

	public User queryUser(Integer uid);

	public User queryUserByName(String uname);
	
	public ArrayList<User> listUser();
	
	public User updateUser(User user);
	
	public boolean deleteUser(Integer uid);
	
	public User writeCookie(Integer uid);
	
	public User queryCookie(String ucookie);
	
	public boolean deleteCookie(Integer uid);
	
	public boolean deleteVerify(Integer uid);
	
	public void timeOutLogOut(Long currentTime);
	
	public void renewCookieTime(User user);
}
