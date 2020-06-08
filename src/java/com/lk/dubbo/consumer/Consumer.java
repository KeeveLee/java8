package com.lk.dubbo.consumer;

import com.lk.dubbo.framework.Invocation;
import com.lk.dubbo.framework.ProxyFactory;
import com.lk.dubbo.protocol.http.HttpClient;
import com.lk.dubbo.provider.api.HelloService;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-25 23:46
 */
public class Consumer {
    public static void main(String[] args){


        String result = getResult2();


        System.out.println("+++++++++++++");
        System.out.println(result);
        System.out.println("+++++++++++++");


    }

    private static String getResult2() {
        HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation();
        invocation.setInterfaceName(HelloService.class.getName());
        invocation.setMethodName("sayHello");
        invocation.setParamTypes(new Class[]{String.class});
        invocation.setParams(new Object[]{"hi!!!"});


        return httpClient.send("localhost", 8080, invocation);
    }

    private static String getString() {
        HelloService helloServiceProxy = ProxyFactory.getProxy(HelloService.class);
        return helloServiceProxy.sayHello("hi");
    }
}
