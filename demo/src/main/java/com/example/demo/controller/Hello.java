package com.example.demo.controller;

import com.example.demo.netty.Time.NettyServer;
import com.example.demo.netty.Time.TimeClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangrn
 * @version 1.0
 * @date 2021/4/3 15:14
 */
@RestController
public class Hello {

    @GetMapping("/NIOServer")
    public String NIOServer(){
        new Thread(new NettyServer()).start();
        return "server start";
    }

    @GetMapping("/NIOClient")
    public String NIOClient(){
        new Thread(new TimeClient()).start();
        return "client start";
    }
}
