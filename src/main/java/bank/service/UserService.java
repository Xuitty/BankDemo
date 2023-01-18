package bank.service;

import java.util.List;

import bank.entity.User;
import jakarta.mail.SendFailedException;

public interface UserService {
	
	public boolean createUser(User user) throws SendFailedException;

	public User queryUser(Integer uid);

	public User queryUserByName(String uname);
	
	public List<User> listUser();
	
	public User updateUser(User user);
	
	public boolean deleteUser(Integer uid);
	
	public User writeCookie(Integer uid);
	
	public boolean deleteVerify(Integer uid);
}
