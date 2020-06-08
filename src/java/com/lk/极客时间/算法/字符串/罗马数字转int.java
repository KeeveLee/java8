package com.lk.极客时间.算法.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-20 23:25
 */
public class 罗马数字转int {
    public static void main(String[] args){
        int i = romanToInt("III");
        System.out.println(i);
    }
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);


        int len = s.length();
        int res = 0;
        int index = 0;
        while (index < len){
            if ((index + 2) <= len && map.containsKey(s.substring(index, index + 2))){
                res = res + map.get(s.substring(index, index +2));
                index = index + 2;
            }else {
                res = res + map.get(s.substring(index, index +1));
                index = index + 1;
            }
        }
        return res;
    }
}
