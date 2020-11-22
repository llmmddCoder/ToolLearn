package com.sankuai.tool.learn.future;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author liumingdi
 * @version 1.0
 * @date 2020/9/21
 */
//@RunWith(SpringRunner.class)
public class TestFutureGetTimeout {

    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);
//    @Test
    public void testFutureTask(){
        HashMap<Integer, Future<Integer>> map = Maps.newHashMap();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < Math.round(10); i++) {
            map.put(i, getNumberFutureTask(i));
        }
        System.out.println("生成时间:" + (System.currentTimeMillis()-startTime));
        long currentTotalTime = 0L;
        for (Map.Entry<Integer, Future<Integer>> integerFutureEntry : map.entrySet()) {
            try {
                if (currentTotalTime > 100){
                    integerFutureEntry.getValue().get(20, TimeUnit.MILLISECONDS);
                }else {
                    integerFutureEntry.getValue().get(100, TimeUnit.MILLISECONDS);
                    currentTotalTime = System.currentTimeMillis()-startTime;
                }
                //integerFutureEntry.getValue().get(100, TimeUnit.MILLISECONDS);


            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(integerFutureEntry.getKey() + "-执行时间:" + (System.currentTimeMillis()-startTime));
        }
        System.out.println("结束时间:" + (System.currentTimeMillis()-startTime));
    }

    public Future<Integer> getNumberFutureTask(final int fs) {
        return THREAD_POOL.submit(new Callable<Integer>() {
            @Override
            public Integer call () throws Exception {
                Thread.sleep(fs*15);
                return fs;
            }
        });
    }
}
