package com.nitzsch.java.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nitzschhong
 * @create: 2022-03-09 00:54
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String key = "key";
        map.put(key, 3);
//        map.merge(key, 1, (oldValue, incr) -> oldValue + incr);
        map.merge(key, 1, Integer::sum);
        System.out.println(map.get(key));
    }
}
