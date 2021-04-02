package com.example.demo.Runnable;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author huangrn
 * @version 1.0
 * @date 2021/1/27 15:47
 */
public class SocketServer1 implements Runnable {


    @SneakyThrows
    @Override
    public void run() {
        ServerSocket  serverSocket = new ServerSocket(8082);
        try {

            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                int meLen = 2048;
                byte[] context = new byte[2048];
                int read = inputStream.read(context, 0, meLen);
                String message = new String(context, 0, 2048);
                System.out.println(message);
                outputStream.write(("收到").getBytes());
                inputStream.close();
                outputStream.close();
                socket.close();

            }
        } catch (IOException e) {
            serverSocket.close();
            e.printStackTrace();
        }finally {
            serverSocket.close();
        }
    }
}
