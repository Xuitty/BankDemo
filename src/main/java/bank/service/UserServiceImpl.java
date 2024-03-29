package bank.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.dao.UserDAOInterface;
import bank.entity.User;
import bank.tools.JavaMailTools;
import bank.tools.MD5Tools;
import bank.tools.PasswordGenerator;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserDAOInterface userDAOInterface;
	@Autowired
	PasswordGenerator passwordGenerator;
	@Autowired
	MD5Tools md5Tools;
	@Autowired
	JavaMailTools javaMailTools;

	@Transactional
	@Override
	public boolean createUser(User user) throws MessagingException {
		String salt = passwordGenerator.saltGen(32);
		String encrypted_password = md5Tools.string2MD5(user.getUpassword() + salt);
		String verify = passwordGenerator.verifyGen(6);
		user.setUpassword(encrypted_password);
		user.setUpassword_salt(salt);
		user.setUverify(verify);
		javaMailTools.sendVerify(user.getUname(), user.getUemail(), user.getUverify());
		User result = userDAOInterface.save(user);
		return result.getUid() != null ? true : false;
	}

	@Transactional
	@Override
	public User queryUser(Integer uid) {
		User user = userDAOInterface.findByUid(uid);
		return user;
	}

	@Transactional
	@Override
	public User queryUserByName(String uname) {
		User user = userDAOInterface.findByUname(uname);
		return user;
	}

	@Override
	public boolean checkUserPass(User user, String pass) {
		if(user.getUpassword().equals(md5Tools.string2MD5(pass + user.getUpassword_salt()))){
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public ArrayList<User> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public User updateUser(User user) {
		User user_new = userDAOInterface.save(user);
		return user_new;
	}

	@Transactional
	@Override
	public boolean deleteUser(Integer uid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public User writeCookie(Integer uid) {
		User user = queryUser(uid);
		String salt = passwordGenerator.saltGen(32);
		user.setUcookie_salt(salt);
		user.setUcookie(md5Tools.string2MD5(user.getUname() + salt));
		updateUser(user);
		return user;
	}

	@Transactional
	@Override
	public User queryCookie(String ucookie) {
		User user = userDAOInterface.findByUcookie(ucookie);

		return user;
	}

	@Transactional
	@Override
	public boolean deleteCookie(Integer uid) {
		User user = queryUser(uid);
		user.setUcookie(null);
		user.setUcookie_salt(null);
		updateUser(user);
		return false;
	}

	@Transactional
	@Override
	public boolean deleteVerify(Integer uid) {

		User user = queryUser(uid);
		user.setUverify(null);
		updateUser(user);
		return false;
	}

	@Transactional
	@Override
	public void timeOutLogOut(Long currentTime) {
		ArrayList<User> list = userDAOInterface.findByLasttimeLessThan(currentTime);
		for (User user : list) {
			user.setUcookie(null);
			user.setUcookie_salt(null);
		}
		userDAOInterface.saveAll(list);
	}

	@Transactional
	@Override
	public void renewCookieTime(User user) {
		userDAOInterface.save(user);
	}

}
