package com.lk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-01-07 00:08
 */
public class 筛选 {
    public static void main(String[] args){

        List<Apple> apples = Arrays.asList(new Apple(10,"red"),
                                           new Apple(150,"green"));
        List<Apple> res = filter(apples, (Apple apple) -> apple.getColor().equals("red"));
        for (Apple apple : res){
            System.out.println(apple);
        }

    }
    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate applePredicate){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : apples){
            if (applePredicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> res = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                res.add(t);
            }
        }
        return res;
    }

}
