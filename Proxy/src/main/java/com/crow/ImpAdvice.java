package com.crow;

import java.lang.reflect.Method;

/**
 * Created by CrowHawk on 17/2/20.
 */
public class ImpAdvice implements Advice {
    long beginTime = 0;
    public void forwardMethod(Method method){
        System.out.println("end");
        beginTime = System.currentTimeMillis();
    }

    public void backMethod(Method method){
        System.out.println("start");
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName() + " running time of " + (endTime - beginTime));
    }
}
