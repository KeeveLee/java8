package com.lk.极客时间.算法.排序算法;

import com.lk.utils.JsonUtil;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-12 18:01
 */
public class 冒泡排序 {
    public static void main(String[] args) {

        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        int[] arr2 = new int[]{3, 5, 4, 1, 2, 6};
        bubbleSort(arr2);
    }

    public static void bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // 提前退出冒泡循环的标识位
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            System.out.println(i + " ： "+JsonUtil.toStringWithoutException(arr));
            if (!flag){
                break;
            }
        }
    }
}
