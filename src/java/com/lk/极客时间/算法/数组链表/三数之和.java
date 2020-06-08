package com.lk.极客时间.算法.数组链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * @author likai
 * @date 2019-11-23 20:33
 */
public class 三数之和 {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, -2, -1};
//        int[] nums = new int[]{-2, 0, 1, 1, 2};
        int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums1));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int j = i + 1;
            int k = len - 1 ;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j<k && nums[j] == nums[j +1]){
                        j++;
                    }
                    while (j<k && nums[k] == nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }else if (sum<0){
                    j++;
                }else if (sum >0){
                    k--;
                }
            }
        }

        return res;
    }
}
