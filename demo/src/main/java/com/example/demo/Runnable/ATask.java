package com.example.demo.Runnable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangrn
 * @version 1.0
 * @date 2021/1/27 10:32
 */
public class ATask implements Callable {
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    private AtomicInteger a = new AtomicInteger(0);
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return a;
    }
}
