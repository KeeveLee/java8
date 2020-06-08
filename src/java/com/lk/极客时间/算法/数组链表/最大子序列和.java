package com.lk.极客时间.算法.数组链表;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-05-03 13:15
 */
public class 最大子序列和 {
    public static void main(String[] args){
        int[] nums = new int[]{-2,1};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
    public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            nums[i] += Math.max(nums[i-1], 0);
            res = Math.max(nums[i], res);
        }
        return res;
    }
}
