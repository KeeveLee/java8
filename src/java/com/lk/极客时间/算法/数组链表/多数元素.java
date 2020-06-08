package com.lk.极客时间.算法.数组链表;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-05-02 18:10
 */
public class 多数元素 {
    public static void main(String[] args){
        int[] nums = new int[]{1,1,2};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = map.getOrDefault(num, 0);
            map.put(num, orDefault +1);
        }
        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()>(nums.length /2)){
                return entry.getKey();
            }

        }

        return -1;
    }
}
