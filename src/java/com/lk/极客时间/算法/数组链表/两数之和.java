package com.lk.极客时间.算法.数组链表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-23 20:01
 */
public class 两数之和 {

    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 4};
        int target = 2;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        System.out.println(Arrays.toString(twoSum2(nums, target)));
        System.out.println(Arrays.toString(twoSum3(nums, target)));
    }

    /**
     * 如果没有元素都不重复
     * the best
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)){
                return new int[]{i , map.get(t)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};

    }
    /**
     * 如果没有元素都不重复
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (null != map.get(t) && i != map.get(t)){
                return new int[]{i, map.get(t)};
            }
        }
        return new int[]{};

    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length -1; i++) {
            int t = target - nums[i];
            for (int j = i+1; j< nums.length; j++ ){
                if (t == nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
