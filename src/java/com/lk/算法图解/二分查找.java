package com.lk.算法图解;

/**
 * Description:
 *
 * @author likai
 * @date 2019-11-11 23:25
 */
public class 二分查找 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int i = binarySearch(arr, 1);
        System.out.println(i);

    }

    public static int binarySearch(int[] arr, int target) {
        if (arr.length <= 0) {
            return -1;
        }
        int l = 0;
        int h = arr.length - 1;
        // 这里是 <=
        while (l <= h) {
            // m 是局部变量
            int m = (l + h) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else if (arr[m] > target) {
                h = m - 1;
            } else if (arr[m] == target) {
                return m;
            }
        }
        return -1;
    }
}
