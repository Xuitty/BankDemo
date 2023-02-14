package bank.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import bank.dao.TransferDAOInterface;
import bank.entity.Transfer;
@Component
public class CreateNewTask {
	
	@Autowired
	Scheduler scheduler;
	@Autowired
	TransferDAOInterface transferDAOInterface;
	
	public void create() throws ClassNotFoundException, NoSuchMethodException, SchedulerException {
	MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
	methodInvokingJobDetailFactoryBean.setTargetObject(new Task());
	methodInvokingJobDetailFactoryBean.setTargetMethod("transferVerifyTimeout");
	methodInvokingJobDetailFactoryBean.setName("transferVerifyTimeout");
	Transfer t = new Transfer();
	t.setTid(55688);
	methodInvokingJobDetailFactoryBean.setArguments(t);
	methodInvokingJobDetailFactoryBean.setConcurrent(false);
	methodInvokingJobDetailFactoryBean.afterPropertiesSet();
	SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
	simpleTriggerFactoryBean.setStartTime(new Date(new Date().getTime()+5000L));
	simpleTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean.getObject());
	simpleTriggerFactoryBean.setRepeatCount(0);
	simpleTriggerFactoryBean.afterPropertiesSet();
	
	
	scheduler.scheduleJob(methodInvokingJobDetailFactoryBean.getObject(),simpleTriggerFactoryBean.getObject());
//	System.out.println(transferDAOInterface.findByVerifyEquals(null));
//	System.out.println(new SimpleDateFormat().toPattern() .format(new Date().getTime()));

}
class Task{
	void transferVerifyTimeout(Transfer transfer) {
		System.out.println(transfer.getTid());
		System.out.println("success");
	}
}
}
