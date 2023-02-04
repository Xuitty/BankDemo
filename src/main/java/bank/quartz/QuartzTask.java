package bank.quartz;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import bank.service.UserService;

@Configuration
@Component
@EnableScheduling
public class QuartzTask {
	
	@Autowired
	UserService userService;

    public void timeOutLogOutService() {
    	Long now = new Date().getTime();
    	userService.timeOutLogOut(now);
    }
    
}
