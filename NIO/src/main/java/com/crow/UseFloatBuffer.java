package com.crow;

import java.nio.FloatBuffer;

/**
 * Created by CrowHawk on 17/9/4.
 */
public class UseFloatBuffer {
    public static void main(String[] args) throws Exception{
        FloatBuffer buffer = FloatBuffer.allocate(10);
        for(int i = 0; i < buffer.capacity(); i++) {
            float f = (float)Math.sin((((float)i)/10)*(2*Math.PI));
            buffer.put(f);
        }
        buffer.flip();
        while(buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
