package com.lk.极客时间.算法;

/**
 * Description:
 * <p>
 * x 的 n 次方
 * pow（x, n）
 *
 * @author likai
 * @date 2019-08-04 13:04
 */
public class 递归分治 {

    public static void main(String[] args) {
        float i = myPow(2, 3);
        System.out.println(i);
        System.out.println(myPow2(2, 3));
    }

    private static float myPow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        if (n % 2 != 0) {
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2);

    }
    private static float myPow2(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        if (n % 2 == 0) {
            return myPow(x, n/2) * myPow(x, n/2);
        }
        return x *  myPow(x, (n-1) / 2) * myPow(x, (n-1) / 2);

    }
}
