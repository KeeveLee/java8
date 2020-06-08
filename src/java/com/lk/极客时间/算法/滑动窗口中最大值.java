package com.lk.极客时间.算法;

import com.lk.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likai
 * @date 2020-03-31 21:49
 */
@Slf4j
public class 滑动窗口中最大值 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Queue<Integer> q = new LinkedList<>();
        System.out.println(JsonUtil.toStringWithoutException(maxSlidingWindow1(nums, k)));
        System.out.println(JsonUtil.toStringWithoutException(maxSlidingWindow2(nums, k)));

    }

    /**
     * n * k * logk
     */
    private static Integer[] maxSlidingWindow1(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();

        for (int num : nums) {
            if (list.size() < k - 1) {
                list.add(num);
            } else {
                list.add(num);
                List<Integer> collect = new ArrayList<>(list);
                collect.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                resultList.add(collect.get(0));
                list.remove(0);
            }
        }
        return resultList.toArray(new Integer[0]);
    }

    private static int[] maxSlidingWindow2(int[] nums, int k) {
        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int start = 0;
        int end = nums.length;
        int[] resp = new int[end - k + 1];
        int index = 0;
        for (int i = 0; i < end; i++) {
            queue.add(nums[i]);
            if (queue.size() == k) {
                i = start;
                start++;
                resp[index] = queue.peek();
                System.out.println(JsonUtil.toStringWithoutException(queue));
                index++;
                queue.clear();
            }
        }
        return resp;
    }

    /**
     * 双端队列
     */
    private static int[] maxSlidingWindow3(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        return null;
    }

}
