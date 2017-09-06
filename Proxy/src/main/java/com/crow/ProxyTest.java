package com.crow;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by CrowHawk on 17/2/20.
 */
public class ProxyTest {
    public static void main(String args[]){
        ArrayList<String> target = new ArrayList<>();//创建目标类的实例对象
        ImpAdvice impAdvice = new ImpAdvice();
        Collection proxy = (Collection) getProxy(target, impAdvice);//创建动态类
        proxy.add("aa");
        System.out.println(proxy.size());
        System.out.println(proxy.getClass().getName());

    }

    public static Object getProxy(final Object target, final Advice advice){
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {//动态类通过Invocation类的invoke方法调用目标类所需的方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
                        advice.forwardMethod(method);
                        Object retVal = method.invoke(target, args);
                        advice.backMethod(method);
                        return retVal;
                    }
                }
        );
        return proxy;
    }

}
