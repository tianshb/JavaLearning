package com.crow;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by CrowHawk on 17/9/4.
 */
public class ReadAndShow {//从文件中读取数据并打印
    public static void main(String[] args) throws Exception{
        FileInputStream fin = new FileInputStream("ReadAndShow.txt");
        FileChannel fc = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        buffer.flip();
        for(int i = 0; buffer.remaining() > 0; i++) {
            System.out.println("Character" + i + ": " + (char)buffer.get());
        }
        fin.close();
    }
}
