package xiaoyaook.discardserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * created by xiaoyaook on 18-8-25
 *
 * 处理服务端的 channel
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
//        // 丢弃接收的消息
//        ((ByteBuf) msg).release(); // (3)
//    }

//    可以把接收到的消息
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf in = (ByteBuf) msg;
//        try {
//            while (in.isReadable()) { // (1)
//                System.out.print((char) in.readByte());
//                System.out.flush();
//            }
//        } finally {
//            ReferenceCountUtil.release(msg); // (2)
//        }
//    }


    // Echo server
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg); // 调用write（Object）来逐字写入接收到的消息，注意我们在这里没有release，因为当数据被写入到wire时，netty会自动帮我们release
        ctx.flush(); // 调用write（Object）不会直接写入到wire，它首先在内部缓冲，然后通过ctx.flush（）刷新到wire
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
