package com.lk.极客时间.算法;

import com.sun.tools.javac.util.StringUtils;

import javax.swing.*;
import java.io.PipedReader;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-05-20 11:17
 */
public class 有效的字母异位词 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        System.out.println(isValidAnagram(s1, s2));

        System.out.println(isValid(s1, s2));
        System.out.println(isValid2(s1, s2));
        System.out.println(isValid3(s1, s2));


    }

    private static boolean isValid3(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>(s1.length());
        Map<Character, Integer> map2 = new HashMap<>(s2.length());

        for (char c : s1.toCharArray()) {
            map1.putIfAbsent(c, map1.get(c) == null ? 1 : map1.get(c) + 1);
        }

        for (char c : s2.toCharArray()) {
            map2.putIfAbsent(c, map2.get(c) == null ? 1 : map1.get(c) + 1);
        }
        return map1.equals(map2);

    }

    private static boolean isValid2(String s1, String s2) {
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);

    }

    private static boolean isValid(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }
        char[] chars1 = s2.toCharArray();
        for (char c : chars1) {
            if (map.containsKey(c)) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);

                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }


    private static boolean isValidAnagram(String s1, String s2) {
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        String[] split1 = s1.split("");
        for (String a : split1) {

            m1.merge(a, 1, (v1, v2) -> v1 + v2);
        }
        System.out.println(m1);

        String[] split2 = s2.split("");

        for (String a : split2) {
            m2.merge(a, 1, (v1, v2) -> v1 + v2);
        }
        System.out.println(m2);
        return m1.equals(m2);
    }
}
