package com.lk.dubbo.register;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-25 23:26
 */
public class LocalRegister {
    private static Map<String, Class> map = new HashMap<String, Class>();
    public static void regist(String interfaceName, Class implClass){
        map.put(interfaceName, implClass);
    }
    public static Class get(String interfaceName){
        return map.get(interfaceName);
    }

}
