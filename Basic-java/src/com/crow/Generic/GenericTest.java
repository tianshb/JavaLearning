package com.crow.Generic;

/**
 * Created by CrowHawk on 17/2/16.
 */


import java.lang.reflect.*;
import java.util.*;

public class GenericTest {
    public static void main(String[] args) throws Exception{
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Tom", 1);
        hashMap.put("Jerry", 2);
        hashMap.put("Nick", 3);
        printHashmap(hashMap);

        String[] array = new String[]{"crow","martin","pattie"};
        swap(array, 1, 2);
        System.out.println("array[2] = " + array[2]);

        //用反射的方法获取printHashmap方法的参数并打印
        Method printMethod = GenericTest.class.getMethod("printHashmap", HashMap.class);
        Type[] types = printMethod.getGenericParameterTypes();
        ParameterizedType parameterizedType = (ParameterizedType)types[0];
        Type[] actualTypes = parameterizedType.getActualTypeArguments();
        System.out.println("The paratype is " + parameterizedType.getRawType() + "<" + actualTypes[0] + "," + actualTypes[1] + ">");
    }


    public static void printHashmap(HashMap<String, Integer> hashMap){//遍历HashMap并打印其内容
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

    public static <T> void swap(T[] arr, int i, int j){//交换泛型数组中的任意两个元素
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
