package com.crow;

import java.nio.ByteBuffer;

/**
 * Created by CrowHawk on 17/9/4.
 */
public class CreateBuffer {
    public static void main( String args[] ) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate( 1024 );

        buffer.put( (byte)'a' );
        buffer.put( (byte)'b' );
        buffer.put( (byte)'c' );

        buffer.flip();

        System.out.println( (char)buffer.get() );
        System.out.println( (char)buffer.get() );
        System.out.println( (char)buffer.get() );
    }
}
