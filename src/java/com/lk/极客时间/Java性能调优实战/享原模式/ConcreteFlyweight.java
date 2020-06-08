package com.lk.极客时间.Java性能调优实战.享原模式;

/**
 * Description: 具体享原元类
 *
 * @author likai
 * @date 2019-12-31 13:30
 */
public class ConcreteFlyweight implements Flyweight {


    private String type;

    public ConcreteFlyweight(String type) {
        this.type = type;
    }

    @Override
    public void operation(String name) {
        System.out.printf("[类型(内在状态)] - [%s] - [名字(外在状态)] - [%s]\n", type, name);
    }

    @Override
    public String getType() {
        return type;
    }
}
