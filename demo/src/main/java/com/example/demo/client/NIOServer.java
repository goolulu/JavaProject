package com.example.demo.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author huangrn
 * @version 1.0
 * @date 2021/4/3 13:08
 */
public class NIOServer implements Runnable{
    @Override
    public void run() {

        try {

            Selector selector = Selector.open();

            ServerSocketChannel ssChannel = ServerSocketChannel.open();
            ssChannel.configureBlocking(false);
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);

            ServerSocket serverSocket = ssChannel.socket();
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
            serverSocket.bind(address);

            while (true) {

                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = keys.iterator();

                while (keyIterator.hasNext()) {

                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {

                        ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();

                        // 服务器会为每个新连接创建一个 SocketChannel
                        SocketChannel sChannel = ssChannel1.accept();
                        sChannel.configureBlocking(false);

                        // 这个新连接主要用于从客户端读取数据
                        sChannel.register(selector, SelectionKey.OP_READ);

                    } else if (key.isReadable()) {

                        SocketChannel sChannel = (SocketChannel) key.channel();
                        sChannel.close();
                    }

                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
