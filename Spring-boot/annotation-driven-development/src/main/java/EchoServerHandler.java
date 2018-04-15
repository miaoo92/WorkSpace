import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger log = Logger.getLogger(EchoServerHandler.class.getName());


    /**
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        log.info(ctx.channel().remoteAddress()+""+cause.getMessage());
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String inMsg = ((ByteBuf)msg).toString(CharsetUtil.UTF_8);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String returnTime = null;
        if("QUERY TIME ORDER".equalsIgnoreCase(inMsg)){
            returnTime = sdf.format(new Date(System.currentTimeMillis())).toString();
        }else {
            returnTime = "BAD REQUEST";
        }

        ByteBuf responseBuf = Unpooled.copiedBuffer(returnTime.getBytes());
//        ChannelHandlerContext是我们在处理链中所传输信息的一种类型
        ctx.write(responseBuf);


    }

    /**
     * 就是来确定我们的channel通道信息有没有全部写入
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //监听器思想 这句话的意思是将暂时存在Channel里面的buffer里面的信息，全部写出到套接字
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);

    }
}
