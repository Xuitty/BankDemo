package bank.quartz;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import bank.entity.Transfer;
import bank.service.TransferService;
import bank.service.UserService;

@Configuration
@Component
@EnableScheduling
public class QuartzTask {
	
	@Autowired
	UserService userService;
	@Autowired
	TransferService transferService;
	

    public void timeOutLogOutService() {
    	Long now = new Date().getTime();
    	userService.timeOutLogOut(now);
    	System.out.println("done");
    }
    
    public void scheduleTransferCheckService() {
		String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
		System.out.println(transferService.excuteScheduleTransfer(dateTime));
    }
}
