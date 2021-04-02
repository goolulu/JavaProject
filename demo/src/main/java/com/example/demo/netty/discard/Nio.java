package com.example.demo.netty.discard;

import io.netty.buffer.ByteBuf;
import org.apache.ibatis.annotations.SelectKey;

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
 * @date 2021/3/30 8:42
 */
public class Nio {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel Channel = ServerSocketChannel.open();
        Channel.configureBlocking(false);
        Channel.register(selector, SelectionKey.OP_ACCEPT|SelectionKey.OP_READ);
        ServerSocket serverSocket = Channel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);
        serverSocket.bind(inetSocketAddress);
        while (true) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = ((ServerSocketChannel)key.channel()).accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                if (key.isReadable()) {
                    SocketChannel channel =(SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    StringBuffer sbuf = new StringBuffer();
                    while (true) {
                        buffer.clear();
                        int n = channel.read(buffer);
                        if (n == -1) {
                            break;
                        }
                        buffer.flip();
                        sbuf.append(buffer.toString());
                    }

                }
            }
        }
    }
}
