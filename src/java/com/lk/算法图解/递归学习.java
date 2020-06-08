package com.lk.算法图解;

/**
 * Description:
 * 要结合调用栈学习
 * 所有函数调用都进入调用栈
 * 递归函数有两部分：
 *  1 基线条件：函数不再调用自己
 *  2 递归条件：函数调用自己
 *
 * @author likai
 * @date 2019-11-12 20:13
 */
public class 递归学习  {

    public static void main(String[] args){
        System.out.println(factorial(3));
    }


    /**
     * 阶乘 n！
     */
    private static int factorial(int n){
        // 基线条件
        if (1 == n){
            return 1;
        }
        // 递归条件
        return n * factorial(n -1);
    }
}
