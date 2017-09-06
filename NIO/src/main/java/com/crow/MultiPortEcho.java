package com.crow;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by CrowHawk on 17/9/4.
 */
public class MultiPortEcho {
    private int ports[];
    private ByteBuffer echoBuffer = ByteBuffer.allocate( 1024 );

    public MultiPortEcho( int ports[] ) throws IOException {
        this.ports = ports;

        go();
    }

    private void go() throws IOException {

        Selector selector = Selector.open();

        // Open a listener on each port, and register each one
        // with the selector
        for (int i=0; i < ports.length; i++) {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ServerSocket ss = ssc.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            ss.bind(address);

            //将新打开的 ServerSocketChannels 注册到 Selector上，指定监听accept事件
            SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Going to listen on " + ports[i]);
        }

        while (true) {
            int num = selector.select();//返回该选择器中对I/O事件准备就绪的channel对应的key的数量
            Set selectedKeys = selector.selectedKeys();//返回key的集合
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()) {//遍历key集合，集合中的元素为SelectionKey类型
                SelectionKey key = (SelectionKey) it.next();
                if ((key.readyOps() & SelectionKey.OP_ACCEPT)
                        == SelectionKey.OP_ACCEPT) {//检查发生了什么类型的事件
                    // Accept the new connection
                    ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking( false );

                    // Add the new connection to the selector
                    SelectionKey newKey = sc.register( selector, SelectionKey.OP_READ );//监听read事件
                    //Selector不会自己从已选择键集中移除SelectionKey实例。必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中。
                    it.remove();

                    System.out.println( "Got connection from "+sc );
                }else if ((key.readyOps() & SelectionKey.OP_READ)
                        == SelectionKey.OP_READ) {
                    // Read the data
                    SocketChannel sc = (SocketChannel)key.channel();

                    // Echo data
                    int bytesEchoed = 0;
                    while (true) {
                        echoBuffer.clear();
                        int r = sc.read( echoBuffer );

                        if (r<=0) {
                            break;
                        }
                        echoBuffer.flip();

                        sc.write( echoBuffer );
                        bytesEchoed += r;
                    }

                    System.out.println( "Echoed "+bytesEchoed+" from "+sc );

                    it.remove();
                }
            }
        }
    }

    public static void main( String args[] ) throws Exception {
        if (args.length<=0) {
            System.err.println( "Usage: java MultiPortEcho port [port port ...]" );
            System.exit( 1 );
        }

        int ports[] = new int[args.length];

        for (int i=0; i<args.length; ++i) {
            ports[i] = Integer.parseInt( args[i] );
        }

        new MultiPortEcho( ports );
    }


}
