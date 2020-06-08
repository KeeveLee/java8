package com.lk.dubbo.provider.api.impl;

import com.lk.dubbo.provider.api.HelloService;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-25 23:31
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String msg) {
        return "###" + msg;
    }
}
