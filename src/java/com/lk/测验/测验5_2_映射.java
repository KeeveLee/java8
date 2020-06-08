package com.lk.测验;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-03-24 13:01
 */
public class 测验5_2_映射 {
    public static void main(String[] args) {

        fun1();
        fun2();
        fun3();

    }

    /**
     * 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢?例如，给定[1, 2, 3, 4,5]，应该返回[1, 4, 9, 16, 25]
     */
    public static void fun1() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> output = input.stream().map(n -> n * n).collect(Collectors.toList());
        output.stream().forEach(System.out::println);
    }

    /**
     * 给定两个数字列表，如何返回所有的数对呢?例如，给定列表[1, 2, 3]和列表[3, 4]，应 该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代表数对。
     */
    public static void fun2() {
        List<Integer> in1 = Arrays.asList(1, 2, 3);
        List<Integer> in2 = Arrays.asList(3, 4);
        List<int[]> out = in1.stream().flatMap(i -> in2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
    }

    /**
     * 如何扩展前一个例子，只返回总和能被3整除的数对呢?例如(2, 4)和(3, 3)是可以的
     */
    public static void fun3() {
        List<Integer> in1 = Arrays.asList(1, 2, 3);
        List<Integer> in2 = Arrays.asList(3, 4);
        List<int[]> out = in1.stream().flatMap(i -> in2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(Collectors.toList());
    }
}
