package com.lk.极客时间.算法.数组链表;

//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
// 示例 1:
//
// 输入: nums: [1, 1, 1, 1, 1], S: 3
//输出: 5
//解释:
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
//
//
// 注意:
// 数组非空，且长度不会超过20。
// 初始的数组的和不会超过1000。
// 保证返回的最终结果能被32位整数存下。
//
// Related Topics 深度优先搜索 动态规划

/**
 * 这就是个0-1 背包问题啊。。。
 */
public class 目标和 {

    public static void main(String[] args){
        int[] nums = new int[]{1, 1,1 , 1,1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (Math.abs(sum) < Math.abs(s)) {
            return 0;
        }

        int t = sum * 2 + 1;
        int[][] dp = new int[len][t];
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[1]] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < t; j++) {
                // 边界
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }
        return dp[len - 1][sum + s];
    }
}
