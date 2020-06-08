package com.lk.基础;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-05-17 16:45
 */
public class ChildClass extends SupperClass{
    @Override
    public String getStr(String str) {
        String str1 = super.getStr(str);
        return "child:" + str1;
    }
}
