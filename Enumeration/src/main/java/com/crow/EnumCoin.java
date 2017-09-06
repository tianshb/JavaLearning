package com.crow;

/**
 * Created by CrowHawk on 17/2/12.
 */

public abstract class EnumCoin {//Implement an Enum with a common class
    private int tag;
    private EnumCoin(int tag){
        this.tag = tag;
    }
    public static final EnumCoin OBCERSE = new EnumCoin(1){//an object of an inner class extending EnumCoin
        public EnumCoin enumNext(){
            return BACK;
        }
    };
    public static final EnumCoin BACK = new EnumCoin(0){
        public EnumCoin enumNext(){
            return OBCERSE;
        }
    };

    public String toString(){
        return this == OBCERSE?"Obcerse":"Back";
    }

/*    public EnumCoin enumNext(){
        if(this == OBCERSE){
            return BACK;
        }
        else{
            return OBCERSE;
        }
    }*/

    public abstract EnumCoin enumNext();
}