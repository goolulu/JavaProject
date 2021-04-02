package com.example.demo.Runnable;

/**
 * @author huangrn
 * @version 1.0
 * @date 2021/1/27 10:52
 */
public class BTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
