import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

    private  final int  port;

    public EchoServer(int port) {
        this.port = port;
    }

    //引导模块
    public void start() throws Exception{
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        //创建我们的线程池组维护多个路注册器，在多个注册器上注册channel事件状态
        NioEventLoop group = new NioEventLoop();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group).channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(echoServerHandler);
                        }
                    });

            //异步绑定服务器
            ChannelFuture cf = bootstrap.bind().sync();
            //代码上已经不需要再考虑执行阻塞问题了
            cf.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }

    }

    public static void main(String[] args) throws Exception {
    int port = 8080;
        try {
            new EchoServer(8080).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
