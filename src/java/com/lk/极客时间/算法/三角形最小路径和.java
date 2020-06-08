package com.lk.极客时间.算法;

import java.util.List;

/**
 * Description:
 * https://leetcode-cn.com/problems/triangle/
 *
 * @author likai
 * @date 2020-04-07 23:30
 */
public class 三角形最小路径和 {

    public int minimumTotal(List<List<Integer>> triangle) {

        List<Integer> min = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() -2; i>=0; i--){
            for(int j = 0; j< triangle.get(i).size(); j++){

                min.set(j, triangle.get(i).get(j) + Math.min(min.get(j), min.get(j+1)));
            }
        }
        return min.get(0);
    }
}
