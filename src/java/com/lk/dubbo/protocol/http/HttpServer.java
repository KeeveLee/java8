package com.lk.dubbo.protocol.http;

import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

/**
 * Description: 用内嵌tomcat 启动
 *
 * @author likai
 * @date 2019-11-25 22:41
 */
public class HttpServer {
    public void start(String hostName, Integer port) {
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = tomcat.getConnector();
        connector.setPort(port);

        Engine engine = tomcat.getEngine();
        engine.setDefaultHost(hostName);

        Host host = new StandardHost();
        host.setName(hostName);


        String contextPath = "";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet());
        context.addServletMappingDecoded("/*", "dispatcher");
        try {
            tomcat.start();
            tomcat.getServer().wait();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
