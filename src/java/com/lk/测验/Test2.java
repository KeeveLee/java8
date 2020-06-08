package com.lk.测验;

import java.util.concurrent.TimeoutException;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-04-13 16:15
 */
public class Test2 {

    public static void main(String[] args){

        Exception timeoutException = new TimeoutException();
        System.out.println(timeoutException instanceof TimeoutException);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        stringBuilder.append("b");
        System.out.println(stringBuilder.toString());
    }
}
