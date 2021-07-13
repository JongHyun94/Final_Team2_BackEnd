package com.mycompany.webapp.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

public class CommonValiable {
	public static Scheduler scheduler;

	public static Trigger oneSecTrigger = TriggerBuilder.newTrigger().
			withIdentity(new TriggerKey("job1Key")).
			withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?")).build();

	public static Trigger twoSecTrigger = TriggerBuilder.newTrigger().
			withIdentity(new TriggerKey("job2Key")).
			withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();

}
