package com.lk.dubbo.register;

import com.lk.dubbo.framework.URL;
import org.apache.commons.collections4.CollectionUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-25 23:35
 */
public class RemoteMapRegister {
    // todo zk or redis
    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void regist(String interfaceName, URL url){
        List<URL> list = REGISTER.get(interfaceName);
        if (CollectionUtils.isNotEmpty(list)){
            list.add(url);
            REGISTER.put(interfaceName, list);
        }else {
            REGISTER.put(interfaceName, Collections.singletonList(url));
        }
        saveFile();
    }


    public static URL randomGetUrl(String interfaceName){
        REGISTER = getFile();
        List<URL> list = REGISTER.get(interfaceName);
        Random random = new Random();

        int size = list.size();
        int i = random.nextInt(size);
        return list.get(i);
    }

    private static void saveFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/temp.txt");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<URL>> getFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream("/temp.txt");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyMap();
    }

}
