package com.lk.极客时间.算法.数组链表;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likai
 * @date 2020-04-27 21:31
 */
public class 子集 {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        subsets(nums);
    }
    // test



    public static List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>((int) Math.pow(2, len));
        res.add(new ArrayList<>());

        for (int num : nums) {
            // 需要中间保存
            List<List<Integer>> sub = new ArrayList<>();
            for (List<Integer> curr : res) {
                List<Integer> temp = new ArrayList<>(curr);
                temp.add(num);
                sub.add(temp);
            }
            res.addAll(sub);
        }

        System.out.println(res);
        return res;
    }
}
