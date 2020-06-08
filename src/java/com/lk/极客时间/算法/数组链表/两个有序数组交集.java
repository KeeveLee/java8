package com.lk.极客时间.算法.数组链表;

import com.lk.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-05-01 18:18
 */
public class 两个有序数组交集 {


    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3};
        int[] b1 = new int[]{0,2,3,5};

        int[] ints = retainAll(a1, b1);
        System.out.println(JsonUtil.toString(ints));
        char[] chars1 = new char[]{'a', 'b', 'c'};
        char[] chars2 = new char[]{'a','c'};
        char c = find(chars1, chars2);
        System.out.println(c);
    }

    public static int[] retainAll(int[] array1, int[] array2) {
        if (array1 != null && array2 == null) {
            return new int[]{};
        } else if (array1 == null && array2 != null) {
            return new int[]{};
        } else if (array1 == null) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();
        int a = 0;
        int b = 0;

        while (a < array1.length && b < array2.length) {
            if (array1[a] == array2[b]) {
                list.add(array2[b]);
                a++;
                b++;
            } else if (array1[a] < array2[b]) {
                a++;
            } else {
                b++;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static char find(char[] chars1, char[] chars2){

        int a = 0;
        int b = 0;
        while (a< chars1.length && b<chars2.length){
            if (chars1[a] != chars2[b]){
                return chars1[a];
            }
            a++;
            b++;
        }
        return chars1[chars1.length-1];
    }
}
