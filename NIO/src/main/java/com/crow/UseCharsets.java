package com.crow;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by CrowHawk on 17/9/4.
 */
public class UseCharsets {
    public static void main(String[] args) throws Exception{
        String inputFile = "ReadAndShow.txt";
        String outputFile = "sampleout.txt";
        long inputLength = new File( inputFile ).length();
        RandomAccessFile inf = new RandomAccessFile( inputFile, "r" );
        RandomAccessFile outf = new RandomAccessFile( outputFile, "rw" );

        FileChannel infc = inf.getChannel();
        FileChannel outfc = outf.getChannel();

        MappedByteBuffer inputData =  infc.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);
        Charset latin1 = Charset.forName( "ISO-8859-1" );
        CharsetDecoder decoder = latin1.newDecoder();//解码器
        CharsetEncoder encoder = latin1.newEncoder();//编码器

        CharBuffer cb = decoder.decode( inputData );//将字节数据解码为一组字符
        // Process char data here
        ByteBuffer outputData = encoder.encode( cb );//要写回数据，我们必须使用 CharsetEncoder 将它转换回字节

        outfc.write( outputData );

        inf.close();
        outf.close();

    }
}
