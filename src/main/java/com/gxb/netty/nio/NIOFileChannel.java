package com.gxb.netty.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel {

    public static void main(String[] args) throws IOException {
        String str = "hello,郭雪彪";
        //创建一个输出流->channel
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\file.txt");
        // 通过fileOutputStream获取对应的channel
        // 这个channel真实类型是FileChannelImpl
        FileChannel channel = fileOutputStream.getChannel();
        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        // 将byteBuffer数据写入fileChannel
        channel.write(byteBuffer);
        fileOutputStream.close();

    }
}
