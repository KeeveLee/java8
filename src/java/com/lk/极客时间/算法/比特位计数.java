package com.lk.极客时间.算法;

import com.lk.utils.JsonUtil;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-20 20:33
 */
public class 比特位计数 {

    public static void main(String[] args){
        System.out.println(JsonUtil.toString(countBits(0)));
    }
    public static int[] countBits(int num){

        int[] res = new int[num+1];
        if(num<0){
            return res;
        }
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            if(i%2==0){
                res[i] = res[i/2];
            }else {
                res[i] = res[i-1] +1;
            }
        }
        return res;
    }
}
