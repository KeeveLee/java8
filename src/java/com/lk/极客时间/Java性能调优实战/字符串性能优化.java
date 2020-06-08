package com.lk.极客时间.Java性能调优实战;

import org.apache.commons.lang.StringUtils;

/**
 * Description:
 * 03 | 字符串性能优化不容小觑，百M内存轻松存储几十G数据
 *
 * @author likai
 * @date 2019-10-20 15:12
 */
public class 字符串性能优化 {
    public static void main(String[] args){
//        test1();
//        testStringIntern();

//        String v = "aaa免费bb 收费";
        String v = null;
        String a = StringUtils.replace(v, "免费", "");
        String b = StringUtils.replace(a, "收费", "");
        System.out.println(v);
        System.out.println(a);
        System.out.println(b);
    }

    private static void test1(){
        String str1= "abc";
        String str2= new String("abc");
        String str3= str2.intern();

        System.out.println(str1==str2); // false
        System.out.println(str2==str3); // false
        System.out.println(str1==str3); // true
    }

    private static void testStringBuilder(){
        String a = "a";
        StringBuilder stringBuilder = new StringBuilder(a);
        for (int i = 0; i < 10; i++) {
            a =  stringBuilder.append(i).toString();
        }
        System.out.println(a);
    }

    private static void testWhileAppend(){
        String res = "";
        for (int i = 0; i < 10; i++) {
            res = res + i;
        }
    }

    private static String testAdd(){
        String res = "";

        String a = "a";
        String b = "b";
        res = a + b;
        return  res;

    }

    private static void testStringIntern(){
        String a = new String("a").intern();
        String b = new String("a").intern();
        System.out.println(a==b);

        String aa = new String("aa");
        String bb = new String("aa");
        System.out.println(aa == bb);
    }
}
