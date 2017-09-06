package com.crow;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by CrowHawk on 17/9/4.
 */
public class WriteSomeBytes {//将自定义数据写入文件
    static private final byte[] message = { 83, 111, 109, 101, 32, 98, 121, 116, 101, 115, 46 };

    public static void main(String[] args) throws Exception{
        FileOutputStream fout = new FileOutputStream("somebytes.txt");
        FileChannel fc = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for(int i = 0; i < message.length; i++) {
            buffer.put(message[i]);
        }
        buffer.flip();
        fc.write(buffer);
        fout.close();
    }
}
