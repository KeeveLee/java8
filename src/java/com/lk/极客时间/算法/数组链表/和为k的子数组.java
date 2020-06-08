package com.lk.极客时间.算法.数组链表;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-13 14:59
 */
public class 和为k的子数组 {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{28, 54, 7, -70, 22, 65, -6};
        int[] nums3 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(subarraySum(nums1, 3));
        System.out.println(subarraySum(nums2, 100));
        System.out.println(subarraySum(nums3, 0));

        System.out.println(subarraySum2(nums1, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        if (len < 1) {
            return res;
        }

        for (int i = 0; i < len; i++) {
            int temp = 0;
            for (int j = i; j < len; j++) {
                temp += nums[j];
                if (temp == k) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 哈希
     */
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
