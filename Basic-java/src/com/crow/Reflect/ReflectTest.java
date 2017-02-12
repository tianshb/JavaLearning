package com.crow.Reflect;

import java.io.IOException;
import java.lang.reflect.*;


/**
 * Created by CrowHawk on 17/2/8.
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        FieldReflect fr = refConstructor(1,2);
        System.out.println(fr.toString());
        refFieldChange(fr, "a");
        System.out.println("fr.a = " + fr.a);
        refFieldChange(fr, "str1");
        System.out.println("fr.str1 = " + fr.str1);
    }

    public static FieldReflect refConstructor(int a, int b) throws Exception{//使用反射构造器创建对象
        Class[] paralist = {int.class, int.class};
        Constructor cons = FieldReflect.class.getDeclaredConstructor(paralist);
        FieldReflect fr = (FieldReflect) cons.newInstance(a, b);
        return fr;
    }

    public static void refFieldChange(FieldReflect fr, String fieldName) throws Exception{
        //使用Field类改变类的实例域,如果是int型,全部设为3,如果是String类型,将String中的"b"改为"c"
        Field field = fr.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        if(field.getType() == int.class){
            field.set(fr, 3);
        }
        else if(field.getType() == String.class) {
            String string = (String) field.get(fr);
            string.replace("b", "c");
            field.set(fr, string);
        }
        else {
            throw new IOException();
        }
    }
}
