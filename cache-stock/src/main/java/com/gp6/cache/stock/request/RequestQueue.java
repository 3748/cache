package com.gp6.cache.stock.request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 请求内存队列
 *
 * @author gp6
 * @date 2019/11/19
 */
public class RequestQueue {

    /**
     * 内存队列
     */
    private List<ArrayBlockingQueue<Request>> queues = new ArrayList<>();

    /**
     * 静态内部类的方式,初始化单例(线程绝对安全)
     */
    private static class Singleton {
        private static RequestQueue instance;
        static {
            instance = new RequestQueue();
        }
        static RequestQueue getInstance() {
            return instance;
        }

    }

    /**
     * jvm的机制去保证多线程并发安全
     * 内部类的初始化，一定只会发生一次，不管多少个线程并发去初始化
     *
     * @return RequestQueue
     */
    public static RequestQueue getInstance() {
        return Singleton.getInstance();
    }

    /**
     * 添加一个内存队列
     *
     * @param queue ArrayBlockingQueue<Request>
     */
    public void addQueue(ArrayBlockingQueue<Request> queue) {
        this.queues.add(queue);
    }

}
