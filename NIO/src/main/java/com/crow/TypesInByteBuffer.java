package com.crow;

import java.nio.ByteBuffer;

/**
 * Created by CrowHawk on 17/9/4.
 */
public class TypesInByteBuffer {//在ByteBuffer中放入不同类型的数据
    public static void main(String args[]) throws Exception{
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.putInt(30);
        buffer.putChar('a');
        buffer.putDouble(Math.PI);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getDouble());
    }
}
