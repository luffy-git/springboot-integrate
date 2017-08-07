package com.jaood.subscribe.threadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description 线程池配置
 * @Fiel com.jaood.subscribe.threadpool.ExecutorConfig
 * @Author jaood
 * @Date 2017/8/8 0:37
 * @Blog http://blog.csdn.net/jaood
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    /** 线程池维护线程的最少数量 */
    private int corePoolSize = 50;
    /** 线程池维护线程的最大数量，默认为Integer.MAX_VALUE */
    private int maxPoolSize = 1000;
    /** 线程池所使用的缓冲队列，一般需要设置值>=notifyScheduledMainExecutor.maxNum；默认为Integer.MAX_VALUE */
    private int queueCapacity = 20000;
    /** 线程池维护线程所允许的空闲时间，默认为60s */
    private int keepAliveSeconds = 300;

    @Bean
    public Executor mySimpleAsync() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix("mySimpleAsync--");
        //线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
        //AbortPolicy:直接抛出java.util.concurrent.RejectedExecutionException异常
        //CallerRunsPolicy:主线程直接执行该任务，执行完之后尝试添加下一个任务到线程池中，可以有效降低向线程池内添加任务的速度
        //DiscardOldestPolicy:抛弃旧的任务、暂不支持；会导致被丢弃的任务无法再次被执行
        //DiscardPolicy:抛弃当前任务、暂不支持；会导致被丢弃的任务无法再次被执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
