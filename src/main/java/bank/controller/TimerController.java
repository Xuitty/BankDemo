package bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.dao.UserDAOInterface;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class TimerController {
	
	@Autowired
	UserDAOInterface userDAOInterface;
	
//	@Transactional
	@GetMapping("/cookieDeleteService")
	public void cookieDeleteService(){
		System.out.println("success");
	}
	
}
