package com.lk.极客时间.算法;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description:
 *
 * 实现一种特殊的栈（一种先入后出的数据结构），既要满足push（压入栈顶）,pop（弹出栈顶）操作为O(1)时间复杂度，也要满足 min操作（取栈中最小值）为O(1)复杂度
 * @author likai
 * @date 2020-03-31 21:21
 */
public class 求第K大元素 {

    public static void main(String[] args) {

        List<Integer> list = com.sun.tools.javac.util.List.of(1, 4, 19, 3, 8);
        System.out.println(getKth(list, 1));

    }

    public static int getKth(List<Integer> list, int k) {
        // 小顶堆
        Queue<Integer> queue = new PriorityQueue<Integer>(k);


        for (Integer integer : list) {
            if (queue.size() < k) {
                queue.add(integer);
            } else {
                if (queue.peek() < integer) {
                    queue.poll();
                    queue.add(integer);
                }
            }
        }
        return queue.peek();

    }
}
