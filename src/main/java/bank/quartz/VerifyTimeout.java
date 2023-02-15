package bank.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import bank.dao.TransferDAOInterface;
import bank.entity.Transfer;
import bank.service.TransferService;

@Component
public class VerifyTimeout {

//	@Autowired
//	private Scheduler scheduler;
//	@Autowired
//	TransferService transferService;
	TransferService transferService = null;

	public void create(Scheduler scheduler, TransferService transferService, Integer tid)
			throws ClassNotFoundException, NoSuchMethodException, SchedulerException {
		this.transferService = transferService;
		MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
		methodInvokingJobDetailFactoryBean.setTargetObject(new Task());
		methodInvokingJobDetailFactoryBean.setTargetMethod("transferVerifyTimeout");
		methodInvokingJobDetailFactoryBean.setName(String.valueOf(tid));
//	Transfer t = new Transfer();
//	t.setTid(55688);
		methodInvokingJobDetailFactoryBean.setArguments(tid);
		methodInvokingJobDetailFactoryBean.setConcurrent(false);
		methodInvokingJobDetailFactoryBean.afterPropertiesSet();
		SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
//	simpleTriggerFactoryBean.setStartTime(new Date(new Date().getTime()+3010000L));
		simpleTriggerFactoryBean.setStartTime(new Date(new Date().getTime() + 300000L));
		simpleTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean.getObject());
		simpleTriggerFactoryBean.setRepeatCount(0);
		simpleTriggerFactoryBean.afterPropertiesSet();

		scheduler.scheduleJob(methodInvokingJobDetailFactoryBean.getObject(), simpleTriggerFactoryBean.getObject());
		System.out.println("verifyTimerSet");
//	System.out.println(transferDAOInterface.findByVerifyEquals(null));
//	System.out.println(new SimpleDateFormat().toPattern() .format(new Date().getTime()));

	}

	class Task {
		void transferVerifyTimeout(Integer tid) {
			transferService.deleteTransfer(tid);
			System.out.println("deleted");
		}
	}
}
