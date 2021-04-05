package com.example.demo.netty.Time;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author huangrn
 * @version 1.0
 * @date 2021/4/5 8:45
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg; // (1)
        byte[] req = new byte[m.readableBytes()];
        m.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println(body);
    }
}
