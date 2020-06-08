package com.lk.极客时间.算法.数组链表;

import com.lk.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-05-03 16:22
 */
public class 找到数组中消失的数组 {
    public static void main(String[] args){
        int[] nums = new int[]{4,3,2,7,8,2,3,1};// 5 6
        System.out.println(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i< len; i++){
            // 标记使用过的位置为负
            int index = Math.abs(nums[i]) -1;
            if(nums[index]>0){// 表示已经标记过了
                nums[index] *=-1;
            }
            System.out.println(JsonUtil.toString(nums));
        }

        for(int i = 0; i< len; i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }
}
