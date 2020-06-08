package com.lk.基础;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-05-17 16:45
 */
public class MainClass {
    public static void main(String[] args){
        ChildClass childClass = new ChildClass();
        String aaaa = childClass.getStr("aaaa");
        System.out.println(aaaa);
    }
}
