package com.lk.极客时间.算法.数组链表;

import java.util.Arrays;

/**
 * Description:
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likai
 * @date 2020-05-03 19:48
 */
public class 最短无序连续子数组 {
    public static void main(String[] args){
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }

    /**
     * 排序后比较
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int[] o = nums.clone();
        Arrays.sort(nums);
        int len = nums.length;
        int x = len;
        int y =0;
        for (int i = 0; i < len; i++) {
            if(o[i] != nums[i]){
                x = Math.min(x, i);
                y = Math.max(y, i);

            }
        }
        return  (y -x)>=0 ? y -x +1: 0;
    }
}
