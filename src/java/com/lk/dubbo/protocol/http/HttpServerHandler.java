package com.lk.dubbo.protocol.http;

import com.lk.dubbo.framework.Invocation;
import com.lk.dubbo.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-25 23:18
 */
public class HttpServerHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp){
        //处理请求以及返回结果

        try {
            ServletInputStream inputStream = req.getInputStream();

            ObjectInputStream ois = new ObjectInputStream(inputStream);

            Invocation invocation = (Invocation) ois.readObject();

            Class implClass = LocalRegister.get(invocation.getInterfaceName());
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());
            IOUtils.write(result, resp.getOutputStream(), Charset.defaultCharset());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
