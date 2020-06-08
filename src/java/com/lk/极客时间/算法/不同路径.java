package com.lk.极客时间.算法;

import com.lk.utils.JsonUtil;

import java.util.Arrays;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-08 12:08
 */
public class 不同路径 {


    public static void main(String[] args){

        uniquePaths(2,3);
    }

    /**
     * 递推
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {

        int[] cur = new int[n];
        Arrays.fill(cur,1);
        System.out.println( JsonUtil.toStringWithoutException(cur));
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
}
