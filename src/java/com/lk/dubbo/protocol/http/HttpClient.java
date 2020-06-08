package com.lk.dubbo.protocol.http;

import com.lk.dubbo.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;


/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-25 23:47
 */
public class HttpClient {
    public String send(String hostName, Integer port, Invocation invocation){

        try {
            URL url = new URL("http", hostName, port, "/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            //注意这是输出流
            OutputStream outputStream = httpURLConnection.getOutputStream();

            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(invocation);
            //todo
            oos.flush();
            oos.close();

            InputStream inputStream = httpURLConnection.getInputStream();

            return IOUtils.toString(inputStream, Charset.defaultCharset());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
