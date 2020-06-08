package com.lk.极客时间.算法.数组链表;

import com.google.common.collect.Lists;
import com.lk.utils.JsonUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * 【0，0，1，1，1】
 * 【0，1，0，1，1】
 *
 * @author likai
 * @date 2020-04-25 20:55
 */
@SuppressWarnings("all")
public class 男女重新排列 {

    public static void main(String[] args){
        int[] arr = new int[]{0, 0, 1, 1, 1, 1};
        int[] res = solution(arr);
        solution2(arr);


    }


    public static int[] solution(int[] arr){
        int len = arr.length;
        Arrays.sort(arr);
        List<Integer> w = Lists.newArrayList();
        List<Integer> m = Lists.newArrayList();
        for (int i : arr) {
            if (i == 0){
                w.add(i);
            }else {
                m.add(i);
            }
        }

        int[] res = new int[len];
        int a = w.size();
        int b = m.size();
        for (int i = 0; i < len; i++) {
            if (i%2 == 0 && a >= 0){
                res[i] = 0;
                a--;
            }
            if (i%2 != 0 && b >=0){
                res[i] = 1;
                b --;
            }
            if(a>=0 && b<0){
                res[i] = 0;
                a--;
            }
            if (a<0 && b >=0){
                res[i] = 1;
                b--;
            }
        }
        System.out.println(JsonUtil.toString(res));
        return res;
    }

    public static int[] solution2(int[] arr){
        int len = arr.length;
        Arrays.sort(arr);
        List<Integer> w = Lists.newArrayList();
        List<Integer> m = Lists.newArrayList();
        int[] res = new int[len];
        int index = 0;
        for (int i : arr) {
            if (i == 0){
                w.add(i);
                res[index] = 0;
                index++;
            }else {
                m.add(i);
                res[index] = 1;
                index++;
            }
        }

        System.out.println(JsonUtil.toString(res));
        return res;
    }

}
