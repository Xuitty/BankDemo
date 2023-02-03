package bank.quartz;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfigration {

    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger... triggers) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 用於quartz集群,QuartzScheduler 啓動時更新己存在的Job
        bean.setOverwriteExistingJobs(true);
        // 延時啓動，應用啓動1秒後
        bean.setStartupDelay(1);
        // 註冊觸發器
        bean.setTriggers(triggers);
        return bean;
    }

    // -------------  -------------\\
    
    
    @Bean(name = "timeOutLogOutServiceDetail") // 指定 jobDetail 名稱
    public MethodInvokingJobDetailFactoryBean timeOutLogOutServiceDetail(QuartzTask task) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setConcurrent(false);
        jobDetail.setTargetObject(task);
        jobDetail.setTargetMethod("timeOutLogOutService");  // 對應上支程式要執行的 method
        return jobDetail;
    }
    
    @Bean
    public CronTriggerFactoryBean timeOutLogOutServiceTrigger(JobDetail timeOutLogOutServiceDetail) { 
        String cron = "0,30 * * * * ? *"; // 排程設定
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(timeOutLogOutServiceDetail);  // 對應要執行的 jobDetail 名稱
        trigger.setCronExpression(cron);
        return trigger;
    }

}