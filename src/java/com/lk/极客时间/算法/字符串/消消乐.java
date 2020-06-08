package com.lk.极客时间.算法.字符串;

import java.util.Stack;

/**
 * Description: 消了816
 *
 * @author likai
 * @date 2020-05-01 08:49
 */
public class 消消乐 {

    public static void main(String[] args) {
        sou("818181666");
        sou("818181668");
    }

    private static String sou(String str) {
        if (null == str || str.length() <= 2) {
            return str;
        }
        StringBuilder res = new StringBuilder();
        Stack<Character> characterStack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (characterStack.size() >= 2) {
                //1
                if (characterStack.peek() == '1' && aChar == '6') {
                    Character one = characterStack.pop();
                    Character eight = characterStack.peek();
                    if (eight == '8') {
                        characterStack.pop();
                    } else {
                        characterStack.push(one);
                        characterStack.push(aChar);
                    }
                } else {
                    characterStack.push(aChar);
                }
            } else {
                characterStack.push(aChar);
            }
        }

        while (!characterStack.isEmpty()) {
            res.insert(0, characterStack.pop());
        }
        System.out.println(res);
        return res.toString();
    }
}
