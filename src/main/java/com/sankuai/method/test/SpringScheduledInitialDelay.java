package com.sankuai.method.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liumingdi
 * @version 1.0
 * @date 2020/11/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {springScheduledTest.class,springScheduledTest.TestConfig.class})
public class SpringScheduledInitialDelay {
    @Test
    public void testScheduled(){
        try {
            Thread.sleep(120000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Configuration
    @EnableScheduling
    public static class TestConfig {
        @Bean
        public ScheduleTask getScheduleTask() {
            return new ScheduleTask();
        }
    }
}

@Component
class ScheduleTask {
    @Scheduled(fixedDelay = 60000, initialDelay = 1000L)
    public void execute() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(new Date().getTime()));
    }
    @Scheduled(fixedDelay = 60000, initialDelay = 5000L)
    public void execute1() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(new Date().getTime()));
    }
}


