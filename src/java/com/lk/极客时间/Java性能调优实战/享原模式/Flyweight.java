package com.lk.极客时间.Java性能调优实战.享原模式;

/**
 * Description: 抽象享元类
 *
 * @author likai
 * @date 2019-12-31 13:27
 */
public interface Flyweight {
    /**
     * 对外状态对象
     */
    void operation(String name);

    /**
     * 对内对象
     */
    String getType();

}
