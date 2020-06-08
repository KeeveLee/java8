package com.lk.极客时间.算法.字符串;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-21 22:40
 */
public class 最长公共前缀 {
    public static void main(String[] args){
        String[] strings = new String[]{"abc", "ab"};
        System.out.println(longestCommonPrefix(strings));

        int a = -1;
        int b = 17;
        System.out.println("ssss "+ (-b * a));
    }
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0){
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) !=0){
                pre = pre.substring(0, pre.length() -1);
                if (pre.isEmpty()){
                    return "";
                }
            }
        }
        return pre;
    }

}
