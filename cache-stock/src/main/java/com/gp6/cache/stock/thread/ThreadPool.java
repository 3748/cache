package com.gp6.cache.stock.thread;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程
 *
 * @author gp6
 * @date 2019/11/06
 */
@Configuration
@EnableAsync
public class ThreadPool implements AsyncConfigurer {
    @Override
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 最小线程数
        taskExecutor.setCorePoolSize(5);
        // 最大线程数
        taskExecutor.setMaxPoolSize(10);
        // 等待队列
        taskExecutor.setQueueCapacity(25);
        // 核心线程
        taskExecutor.setCorePoolSize(3);
        // 空闲线程存活时间
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
