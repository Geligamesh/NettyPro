package com.gxb.netty.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;

public class BasicBuffer {

    public static void main(String[] args) {
        //举例说明buffer的使用
        // 创建一个buffer，大小为5，即可以存放5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //向buffer存放数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        //从buffer中读取数据
        //将buffer转换，读写切换
        intBuffer.flip();
        intBuffer.position(1); // 2,4,6,8
        intBuffer.limit(3);
        while (intBuffer.hasRemaining()) {
             System.out.println(intBuffer.get());
        }
    }
}
