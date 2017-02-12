package com.crow.Reflect;


/**
 * Created by CrowHawk on 17/2/8.
 */
public class FieldReflect {
    public int a;
    private int b;
    public String str1 = "bat";
    public String str2 = "but";
    public String str3 = "bite";

    public FieldReflect(){}
    public FieldReflect(int a,int b){
        super();
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString(){
        return str1 + "," + str2 + "," + str3 + "," + a + "," + b;
    }
}
