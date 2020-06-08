package com.lk.极客时间.算法;

import com.google.common.collect.Lists;
import com.lk.utils.JsonUtil;
import com.sun.tools.javac.util.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-18 18:21
 */
public class Test {
    public static void main(String[] args){
        Object a = new Object();
        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(3);

        Map<Integer, Integer> collect = list
                .stream()
                .collect(Collectors.toMap(n -> n, Integer::intValue));

        System.out.println(JsonUtil.toString(collect));

        int[] ints = Arrays.stream(new int[]{1, 2, 3, 4, 4, 5})
                .distinct()
                .sorted()
                .toArray();




        List<String> strings = Lists.newLinkedList();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("b");
        strings.remove("b");
        strings.remove(0);
        System.out.println(strings);

        test("bbbb");
        test(null);

    }
    private static String test(String str){
        Assert.checkNonNull(str, "aaaa");
        System.out.println(str);
        return str;
    }
}
