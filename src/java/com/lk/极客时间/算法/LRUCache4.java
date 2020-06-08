package com.lk.极客时间.算法;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * LRUCache4 cache = new LRUCache4(2) / 缓存容量
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);     // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);     // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
public class LRUCache4 {

    private int capacity;
    private List<Integer> cacheList = new LinkedList<>();
    private Map<Integer, Integer> cacheMap = new HashMap<>(this.capacity);

    public LRUCache4(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer result = cacheMap.get(key);
        if (result == null) {
            return -1;
        }
        cacheList.add(result);
        if (cacheList.size()> capacity){
            cacheList.remove(0);
        }
        return result;
    }

    public Void put(int key, int value) {
        cacheMap.put(key, value);
        // update list
        cacheList.add(key);
        if (cacheList.size() > capacity) {
            Integer oldKey = cacheList.get(0);
            cacheMap.remove(oldKey);
            cacheList.remove(0);
        }
        return null;
    }

    /**
     * 不清楚为啥通不过。。。
     */
    public static void main(String[] args){
        LRUCache4 cache = new LRUCache4(1);
        System.out.println("null");
        System.out.println(cache.put(2,1));
        System.out.println(cache.get(2));
        System.out.println(cache.put(3, 2));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

    }
}
