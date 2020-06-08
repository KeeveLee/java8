package com.lk.极客时间.算法.排序算法;

import com.lk.utils.JsonUtil;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-12 18:42
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] arr2 = new int[]{3, 5, 4, 1, 2, 6};
        int[] arr = new int[]{4, 5, 6, 1, 3, 2};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    // 数据移动
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            //插入数据
            arr[j + 1] = value;
            System.out.println(i + " : " + j + " : " + JsonUtil.toStringWithoutException(arr));
        }
    }
}
