package com.lk.dubbo.provider;

import com.lk.dubbo.framework.URL;
import com.lk.dubbo.protocol.http.HttpServer;
import com.lk.dubbo.provider.api.HelloService;
import com.lk.dubbo.provider.api.impl.HelloServiceImpl;
import com.lk.dubbo.register.LocalRegister;
import com.lk.dubbo.register.RemoteMapRegister;

import java.io.IOException;

/**
 * Description: simple provider
 *
 * @author likai
 * @date 2019-11-25 22:39
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        // 1 本地注册  {服务名：实现类}
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        // 2 远程注册  {服务名：List<URL>}
        URL url = new URL("localhost", 8080);
        RemoteMapRegister.regist(HelloService.class.getName(), url);

        // 3 启动tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);

    }
}
