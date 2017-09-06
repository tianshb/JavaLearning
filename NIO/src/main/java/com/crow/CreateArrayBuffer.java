package com.crow;

import java.nio.ByteBuffer;

/**
 * Created by CrowHawk on 17/9/4.
 */
public class CreateArrayBuffer {
    static public void main( String args[] ) throws Exception {
        byte array[] = new byte[1024];

        ByteBuffer buffer = ByteBuffer.wrap( array );

        buffer.put( (byte)'a' );
        buffer.put( (byte)'b' );
        buffer.put( (byte)'c' );

        buffer.flip();

        System.out.println( (char)buffer.get() );
        System.out.println( (char)buffer.get() );
        System.out.println( (char)buffer.get() );
    }
}
