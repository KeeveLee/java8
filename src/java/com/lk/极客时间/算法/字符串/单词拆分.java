package com.lk.极客时间.算法.字符串;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likai
 * @date 2020-04-16 19:16
 */
public class 单词拆分 {



    public static void main(String[] args){

        String s = "cars";
        List<String> wordDict = Lists.newArrayList("car", "ca", "rs");
        wordBreak(s, wordDict);
        Map<String, Integer> map = new HashMap<>();
        map.put("a", null);

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            s = s.replace(word, "");
            System.out.println(s);
        }
        if (s.length() == 0){
            return true;
        }
        return false;
    }

}
