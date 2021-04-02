package com.example.demo.filter;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author huangrn
 * @version 1.0
 * @date 2020/12/29 11:19
 */

public class TestFilter implements Filter {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("testFiltesssr init");
    }

    @Override
    public void destroy() {
        System.out.println("testFilter destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("testFilter doFilter");
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getUsername());
        filterChain.doFilter(servletRequest, servletResponse);
    }


    public String toString (ApplicationContext applicationContext) {
        return applicationContext.getId()+";"+
                applicationContext.getApplicationName()+";"+
                applicationContext.getDisplayName();
    }
}
