package com.gp6.cache.stock.thread;

import com.gp6.cache.stock.request.Request;
import com.gp6.cache.stock.request.RequestQueue;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 请求处理线程池,做成单例
 *
 * @author gp6
 * @date 2019/11/19
 */
public class RequestProcessorThreadPool {

    /**
     * 静态内部类的方式,初始化单例(线程绝对安全)
     */
    private static class Singleton {
        private static RequestProcessorThreadPool instance;

        static {
            instance = new RequestProcessorThreadPool();
        }

        static RequestProcessorThreadPool getInstance() {
            return instance;
        }
    }

    /**
     * 初始化
     * jvm的机制去保证多线程并发安全
     * <p>
     * 内部类的初始化，一定只会发生一次，不管多少个线程并发去初始化
     *
     * @return RequestProcessorThreadPool
     */
    public static RequestProcessorThreadPool init() {
        return Singleton.getInstance();
    }

    private RequestProcessorThreadPool() {
        RequestQueue requestQueue = RequestQueue.getInstance();

        for (int i = 0; i < 10; i++) {
            ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<>(100);
            requestQueue.addQueue(queue);
            // 线程池
            ThreadPool threadPool = new ThreadPool();
            ThreadPoolTaskExecutor executor = threadPool.getAsyncExecutor();
            executor.submit(new RequestProcessorThread(queue));
        }
    }






}
