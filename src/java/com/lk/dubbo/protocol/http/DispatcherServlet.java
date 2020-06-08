package com.lk.dubbo.protocol.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-25 23:16
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpServerHandler httpServerHandler = new HttpServerHandler();
        httpServerHandler.handler(req, resp);
    }
}
