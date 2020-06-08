package com.lk.dubbo.framework;

import com.lk.dubbo.protocol.http.HttpClient;
import com.lk.dubbo.register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-03-28 18:35
 */
@SuppressWarnings("all")
public class ProxyFactory {

    public static <T> T getProxy(Class interfaceClass){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient httpClient = new HttpClient();

                Invocation invocation = new Invocation();
                invocation.setInterfaceName(interfaceClass.getName());
                invocation.setMethodName(method.getName());
                invocation.setParamTypes(method.getParameterTypes());
                invocation.setParams(args);

                URL url = RemoteMapRegister.randomGetUrl(interfaceClass.getName());

                return httpClient.send(url.getHostName(), url.getPort(), invocation);
//                return httpClient.send("localhost", 8080, invocation);
            }
        });
    }
}
