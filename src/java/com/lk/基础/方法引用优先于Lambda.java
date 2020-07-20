package com.lk.基础;

import com.google.common.collect.Maps;
import com.lk.utils.JsonUtil;

import java.util.Map;

/**
 * Description:
 *
 * @author likai
 * @date 2020-07-20 08:50
 */
public class 方法引用优先于Lambda {
    public static void main(String[] args) {
        Map<String, Integer> map = Maps.newHashMap();

        // Lambda
        map.merge("kk", 1, (count, incr) -> count + incr);
        System.out.println(JsonUtil.toString(map));
        // 方法引用
        map.merge("kk", 1, Integer::sum);
        System.out.println(JsonUtil.toString(map));
    }
}
