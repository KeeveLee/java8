package com.lk.极客时间.Java性能调优实战.享原模式;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 享元工厂类
 *
 * @author likai
 * @date 2019-12-31 13:32
 */
public class FlyweightFactory {
    //享元池，用来存储享元对象
    private static final Map<String, Flyweight> FLYWEIGHT_MAP = new HashMap<>();

    public static Flyweight getFlyweight(String type) {
        if (FLYWEIGHT_MAP.containsKey(type)) {
            //如果在享元池中存在对象，则直接获取
            return FLYWEIGHT_MAP.get(type);
        } else {
            //在响应池不存在，则新创建对象，并放入到享元池
            ConcreteFlyweight flyweight = new ConcreteFlyweight(type);
            FLYWEIGHT_MAP.put(type, flyweight);
            return flyweight;
        }
    }
}