package com.lk.极客时间.算法.数组链表;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likai
 * @date 2020-04-14 09:07
 */
public class 前K个高频元素 {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        System.out.println(topKFrequent1(nums, 2));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(-Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(0<=Integer.MIN_VALUE);
    }

    /**
     * 最小堆
     */
    public static List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }

    private static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] listArray = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (listArray[i] == null) {
                listArray[i] = new ArrayList();
            }
            listArray[i].add(key);
        }
        f1: for (int i = listArray.length - 1; i >= 0; i--) {
            if (listArray[i] != null) {
                for (Integer integer : listArray[i]) {
                    if (res.size() == k){
                        break f1;
                    }
                    res.add(integer);
                }
            }
        }

        return res;
    }
}
