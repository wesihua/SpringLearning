package com.wei.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * 自动将客户端输入的信息返回到客户端
 * @author weisihua
 * @date 2017年12月13日
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		//ctx.writeAndFlush(msg);
		ByteBuf in = (ByteBuf)msg;
		
		try {
			byte[] bytes = new byte[in.readableBytes()];
			in.readBytes(bytes);
			String body = new String(bytes,"utf-8");
			System.out.println("服务器收到的信息是："+body);
		} finally {
			ReferenceCountUtil.release(in);
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
