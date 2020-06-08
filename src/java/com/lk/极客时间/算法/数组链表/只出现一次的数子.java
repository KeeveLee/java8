package com.lk.极客时间.算法.数组链表;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-05-02 17:59
 */
public class 只出现一次的数子 {
    public static void main(String[] args){
        int[] nums = new int[]{1,1,2};
        singleNumber(nums);
    }
    public static int singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        for (Integer integer : set) {
            return integer;
        }
        return -1;
    }
}
