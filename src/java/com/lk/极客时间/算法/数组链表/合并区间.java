package com.lk.极客时间.算法.数组链表;

import com.lk.utils.JsonUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Description:
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author likai
 * @date 2020-04-16 07:35
 */
public class 合并区间 {

    public static void main(String[] args){

        int[][] intervals = new int[][]{{1,3},{8,10},{3,6},{15,18}};
        int[][] intervals2 = new int[][]{{1,4},{2,3}};

        merge(intervals);

    }
    public static int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length <= 1){
            return intervals;
        }
        // 按照首列排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Stack<int[]> stack = new Stack<>();
        // 行
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] peek = stack.peek();
            int temp = peek[1];
            if (temp>=intervals[i][0] && temp <=intervals[i][1]){
                stack.pop();
                stack.push(new int[]{peek[0], intervals[i][1]});
            }else if (temp < intervals[i][0]){
                stack.push(intervals[i]);
            }
        }

        System.out.println(JsonUtil.toString(stack));
        int[][] res = new int[stack.size()][2];
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
