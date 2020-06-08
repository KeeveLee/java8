package com.lk.极客时间.算法.字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-19 20:51
 */
public class 无重复字符串最长子串 {
    public static int lengthOfLongestSubstring(String s) {

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(lengthOfLongestSubstring(""));//0
        System.out.println("=======");
//        System.out.println(sou("abcabcbb"));
//        System.out.println(sou("bbbbb"));
//        System.out.println(sou("pwwkew"));
//        System.out.println(sou(""));
//        System.out.println(sou(" "));
//        System.out.println(sou("pw"));
        System.out.println(sou("dvdf"));
    }

    public static int sou(String str){
        if (str == null || str.length()<1){
            return 0;
        }
        char[] chars = str.toCharArray();
        int max = 1;
        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();
        for (; r < chars.length; r++) {
            boolean add = set.add(chars[r]);
            if (!add){
                if (max < (r - l)){
                    max = r - l;
                }
                l = r;
                set.clear();
                set.add(chars[r]);
            }else {
                if (max< set.size()){
                    max = set.size();
                }
            }
        }
        return max;
    }
}
