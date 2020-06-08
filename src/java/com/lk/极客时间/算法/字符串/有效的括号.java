package com.lk.极客时间.算法.字符串;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Description: https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author likai
 * @date 2019-11-10 20:20
 */
public class 有效的括号 {
    public static void main(String[] args) {
        String a = "{";
//        System.out.println(isValid(a));
    }

    public static boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        Map<Character, Character> characterMap = new HashMap<>(3);
        characterMap.put(')', '(');
        characterMap.put(']', '[');
        characterMap.put('}', '{');

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!characterMap.containsKey(aChar)) {
                characterStack.push(aChar);
            } else if (characterStack.isEmpty() || !characterMap.get(aChar).equals(characterStack.pop())) {
                return false;
            }
        }
        return characterStack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> characterStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                characterStack.push(')');
            } else if (c == '[') {
                characterStack.push(']');
            } else if (c == '{') {
                characterStack.push('}');
            } else if (characterStack.isEmpty() || c != characterStack.pop()) {
                return false;
            }
        }
        return characterStack.isEmpty();
    }
}
