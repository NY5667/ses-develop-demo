package com.supcon.ses.developer.config.pool;

import com.supcon.ses.developer.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>描述</p>
 *
 * @author lufengdong
 * @create 2023-07-14 15:50
 */
@Configuration
@EnableAsync
@Slf4j
public class ThreadExecutorConfig {

    private final TestThreadExecutorPool testThreadExecutorPool;

    @Autowired
    public ThreadExecutorConfig(TestThreadExecutorPool testThreadExecutorPool){
        this.testThreadExecutorPool = testThreadExecutorPool;
    }

    @Bean(name = "demo1")
    public Executor demo1(){
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        return initExecutor(testThreadExecutorPool, testThreadExecutorPool.getThreadPrefix(), callerRunsPolicy);
    }

    @Bean(name = "demo2")
    public Executor demo2(){
        return initExecutor(testThreadExecutorPool, testThreadExecutorPool.getThreadPrefix(), (r, executor) -> {
            LogUtils.error("队列已满，根据业务自行处理。。。");
        });
    }


    /**
     * 初始化线程池
     */
    private Executor initExecutor(AbstractThreadExecutorPool abstractExecutorPool, String threadName, RejectedExecutionHandler rejectedExecutionHandler){
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(abstractExecutorPool.getCorePoolSize());
        threadPool.setMaxPoolSize(abstractExecutorPool.getMaxPoolSize());
        threadPool.setKeepAliveSeconds(abstractExecutorPool.getKeepAliveSeconds());
        threadPool.setQueueCapacity(abstractExecutorPool.getQueueCapacity());
        threadPool.setThreadNamePrefix(threadName);
        threadPool.setRejectedExecutionHandler(rejectedExecutionHandler);
        threadPool.initialize();
        return threadPool;
    }
}
