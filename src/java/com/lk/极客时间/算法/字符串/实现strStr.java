package com.lk.极客时间.算法.字符串;

/**
 * Description: 相当于indexOf
 *
 * @author likai
 * @date 2019-11-22 18:48
 */
public class 实现strStr {
    public static void main(String[] args){
        String a = "mississippi";
        String b = "issi";
        System.out.println(a.indexOf(b));

        System.out.println("====");
        System.out.println(strStr(a, b));
    }
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (j < chars1.length) {
                if (haystack.charAt(i) == needle.charAt(j)){
                    if (j == (chars1.length -1)){
                        return i -j;
                    }
                    j++;
                }else {
                    i = i - j;
                    j = 0;
                }
            }
        }
        return -1;
    }
}
