package com.lk.极客时间.算法;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-06 15:46
 */
public class 乘积最大子数组 {

    public static void main(String[] args){
        int[] nums = new int[]{-1,-2, -9, -6};
        System.out.println(maxProduct(nums));

    }
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (nums[i] > 0) {
                max = Math.max(cur, cur * max);
                min = Math.min(cur, cur * min);
            } else {
                int temp = Math.max(cur, cur * min);
                min = Math.min(cur, cur * max);
                max = temp;
            }
            res = Math.max(res, max);
        }
        return res;
    }
}