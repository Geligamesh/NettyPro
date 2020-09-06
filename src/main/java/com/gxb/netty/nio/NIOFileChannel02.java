package com.gxb.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NIOFileChannel02 {

    public static void main(String[] args) throws IOException {
        File file = new File("d:\\file.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 通过fileInputStream获取对应的channel
        FileChannel channel = fileInputStream.getChannel();
        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        // 将通道的数据读入到buffer中
        channel.read(byteBuffer);
        // 将字符数组转换成字符串
        System.out.println(new String(byteBuffer.array(), StandardCharsets.UTF_8));
    }
}
