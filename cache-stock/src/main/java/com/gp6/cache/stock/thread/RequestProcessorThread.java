package com.gp6.cache.stock.thread;


import com.gp6.cache.stock.request.Request;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

/**
* 执行请求的工作线程
*
* @author gp6
* @date 2019/11/19
*/
public class RequestProcessorThread implements Callable<Boolean> {

	/**
	 * 自己监控的内存队列
	 */
	private ArrayBlockingQueue<Request> queue;

	RequestProcessorThread(ArrayBlockingQueue<Request> queue) {
		this.queue = queue;
	}
	
	@Override
	public Boolean call() {
		while(true) {
			break;
		}
		return true;
	}

}
