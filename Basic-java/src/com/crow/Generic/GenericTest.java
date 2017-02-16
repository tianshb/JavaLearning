package com.crow.Generic;

/**
 * Created by CrowHawk on 17/2/16.
 */

import java.util.*;

public class GenericTest {
    public static void main(String[] args){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Tom", 1);
        hashMap.put("Jerry", 2);
        hashMap.put("Nick", 3);
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        for(Map.Entry<String, Integer> entry: entrySet){
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
        Iterator<Map.Entry<String, Integer>> iter = entrySet.iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            System.out.print("Key is " + entry.getKey() + ",");
            System.out.println("Value is " + entry.getValue());
        }
    }
}
