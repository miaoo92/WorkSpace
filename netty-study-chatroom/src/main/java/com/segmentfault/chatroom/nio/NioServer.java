package com.segmentfault.chatroom.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * TODO
 *
 * @author miaoo-10492
 * @since 2018/11/7
 */
public class NioServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //创建ServerSocketChannel，监听12345端口
        ssc.socket().bind(new InetSocketAddress(12345));
        ssc.configureBlocking(false);
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        //创建处理器
        Handler handler = new Handler(1024);
        while (true){
            if (selector.select(3000) == 0){
                System.out.println("等待请求超时");
                continue;
            }

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                try {
                    //接受到连接请求时
                    if (key.isAcceptable()){
                        handler.handleAccept(key);
                    }
                    //读取数据
                    if (key.isReadable()){
                        handler.handleRead(key);
                    }
                }catch (IOException ioe){
                    keyIterator.remove();
                    continue;
                }
                //处理完毕后，从待处理的SelectionKey中移除当前所使用的key
                keyIterator.remove();
            }

        }

    }

    private static class Handler{
        private  int bufferSize = 1024;
        private String localCharset = "UTF-8";
        public Handler(){}
        public Handler(int bufferSize){
            this(bufferSize,null);
        }

        public Handler(String localCharset) {
            this(-1,localCharset);
        }

        public Handler(int bufferSize, String localCharset){
            if (bufferSize > 0){
                this.bufferSize = bufferSize;
            }
            if (localCharset != null){
                this.localCharset = localCharset;
            }
        }

        public void handleAccept(SelectionKey selectionKey) throws IOException {
            SocketChannel sc = ((ServerSocketChannel)selectionKey.channel()).accept();
            sc.configureBlocking(false);
            sc.register(selectionKey.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        public void handleRead(SelectionKey selectionKey) throws IOException {
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            ByteBuffer byteBuffer = (ByteBuffer)selectionKey.attachment();
            byteBuffer.clear();
            if (socketChannel.read(byteBuffer) == -1){
                socketChannel.close();
            }else {
                byteBuffer.flip();
                String receive = Charset.forName(localCharset).newDecoder().decode(byteBuffer).toString();
                System.out.println("receive from client:" + receive);

            }
        }

    }
}
