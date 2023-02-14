package bank.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaxxer.hikari.util.ClockSource.Factory;

import bank.dao.TransferDAOInterface;
import bank.entity.Status;
import bank.entity.Transfer;
import bank.quartz.QuartzTask;
import bank.service.AccountService;
import bank.service.TransferService;
import bank.service.UserService;
import bank.tools.JavaMailTools;
import bank.tools.PasswordGenerator;
import jakarta.mail.MessagingException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping

public class TransferController {
	@Autowired
	AccountService accountService;
	@Autowired
	UserService userService;
	@Autowired
	TransferService transferService;
//	@Autowired
//	private Scheduler scheduler;
//	@Autowired
//	BeanFactory beanFactory;

	@PostMapping("doTransfer")
	public Status doTransfer(@RequestBody Transfer transfer) {
		Status result = new Status();
		if (accountService.queryAccountByAaccount(transfer.getSenderAccount()).getAid() == null) {
			result.setStatuss(3);
			result.setMessage("accountNotExist");
			return result;
		}
		PasswordGenerator passwordGenerator = new PasswordGenerator();
		JavaMailTools javaMailTools = new JavaMailTools();
		String verify = passwordGenerator.verifyGen(6);
		try {
			javaMailTools.sendVerify("金發財商業銀行轉帳驗證碼",
					userService.queryUser(accountService.queryAccountByAaccount(transfer.getSenderAccount()).getUid())
							.getUname(),
					userService.queryUser(accountService.queryAccountByAaccount(transfer.getSenderAccount()).getUid())
							.getUemail(),
					verify);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setStatuss(3);
			result.setMessage("emailAddressError");
			return result;
		}
		transfer.setVerify(verify);
		transfer = transferService.updateTransfer(transfer);
		result.setStatuss(1);
		result.setMessage(String.valueOf(transfer.getTid()));
		return result;
	}

	@PostMapping("doVerify")
	public Status doVerify(@RequestBody Transfer transfer) {
		Status result = new Status();
		if (accountService.queryAccountByAaccount(transfer.getSenderAccount()).getAid() == null
				|| accountService.queryAccountByAaccount(transfer.getReceiverAccount()).getAid() == null) {
			result.setStatuss(3);
			result.setMessage("accountNotExist");
		}
		if (transfer.getCurrencyType() == 1 && transfer.getAmountString().contains(".")) {
			result.setStatuss(3);
			result.setMessage("amountCurrencyTypeError");
		}

		return null;
	}

	@GetMapping("scheduleTest")
	public void scheduleTest() throws SchedulerException, ClassNotFoundException, NoSuchMethodException {
//		MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
//		methodInvokingJobDetailFactoryBean.setTargetObject(new Taska());
//		methodInvokingJobDetailFactoryBean.setTargetMethod("test");
//		methodInvokingJobDetailFactoryBean.setName("setTransferTimeout");
//		Transfer t = new Transfer();
//		t.setTid(55688);
//		methodInvokingJobDetailFactoryBean.setArguments(t);
//		methodInvokingJobDetailFactoryBean.setConcurrent(false);
//		methodInvokingJobDetailFactoryBean.afterPropertiesSet();
//		SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
//		simpleTriggerFactoryBean.setStartTime(new Date(new Date().getTime()+5000L));
//		simpleTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean.getObject());
//		simpleTriggerFactoryBean.setRepeatCount(0);
//		simpleTriggerFactoryBean.afterPropertiesSet();
//		
//		
//		scheduler.scheduleJob(methodInvokingJobDetailFactoryBean.getObject(),simpleTriggerFactoryBean.getObject());
//		System.out.println(transferDAOInterface.findByVerifyEquals(null));
//		System.out.println(new SimpleDateFormat().toPattern() .format(new Date().getTime()));

	}
//	class Taska{
//		void test(Transfer transfer) {
//			System.out.println(transfer.getTid());
//			System.out.println("success");
//		}
//	}
}
