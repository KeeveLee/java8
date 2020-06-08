package com.lk.极客时间.算法.字符串;

/**
 * Description:
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 * @author likai
 * @date 2019-11-26 23:41
 */
public class 最后一个单词的长度 {

    public static void main(String[] args){
        String a = " ";
        int i = lengthOfLastWord(a);
        System.out.println(i);
    }
    public static int lengthOfLastWord(String s) {

        String[] s1 = s.split(" ");
        if (s1.length<=0){
            return 0;
        }
        int length = s1.length;
        return s1[length -1].length();

    }
}
