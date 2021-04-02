package com.example.demo.Runnable;

import lombok.SneakyThrows;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

/**
 * @author huangrn
 * @version 1.0
 * @date 2021/1/27 15:36
 */
public class SocketClientRequestThread implements Runnable {
    private static final Log LOGGER = LogFactory.getLog(SocketClientRequestThread.class);
    private CountDownLatch countDownLatch;
    private Integer clientIndex;

    public SocketClientRequestThread(CountDownLatch countDownLatch, Integer clientIndex) {
        this.countDownLatch = countDownLatch;
        this.clientIndex = clientIndex;
    }

    @SneakyThrows
    @Override
    public void run() {
        Socket socket = null;
        OutputStream clientRequest = null;
        InputStream clientResponse = null;
        try {
            socket = new Socket("127.0.0.1", 8082);
            clientRequest = socket.getOutputStream();
            clientResponse = socket.getInputStream();
            this.countDownLatch.await();
            clientRequest.write(("这是第"+this.clientIndex+"发送的请求").getBytes());
            clientRequest.flush();
            int mesLen= 1024;
            byte[] context = new byte[mesLen];
            int redLen;
            String message = "";
            while ((redLen=clientResponse.read(context,0,mesLen))!=-1) {
                message += new String(context, 0, redLen);
            }
            System.out.println(message);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            clientRequest.close();
            clientResponse.close();
        }
    }
}
