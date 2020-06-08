package com.lk.极客时间.算法;

import com.lk.utils.JsonUtil;

import java.util.Stack;

/**
 * Description: TODO
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likai
 * @date 2020-04-08 22:12
 */
public class 每日温度 {
    public static void main(String[] args) {

        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(JsonUtil.toStringWithoutException(dailyTemperatures2(T)));
    }

    /**
     * 暴力
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures1(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static int[] dailyTemperatures2(int[] T) {

        int[] ans = new int[T.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;

    }


}
