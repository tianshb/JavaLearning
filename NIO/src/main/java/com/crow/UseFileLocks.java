package com.crow;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by CrowHawk on 17/9/4.
 */
public class UseFileLocks {
    static private final int start = 10;
    static private final int end = 20;

    public static void main(String[] args) throws Exception {//使用文件锁的示例
        RandomAccessFile raf = new RandomAccessFile("ReadAndShow.txt", "rw");
        FileChannel fc = raf.getChannel();

        //Get Lock
        System.out.println("Trying to get lock.");
        FileLock lock = fc.lock(start, end, false);
        System.out.println( "got lock!" );

        // Pause
        System.out.println( "pausing" );
        try {
            Thread.sleep( 3000 );
        } catch( InterruptedException ie ) {

        }

        // Release lock
        System.out.println( "going to release lock" );
        lock.release();
        System.out.println( "released lock" );

        raf.close();
    }
}
