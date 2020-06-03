package com.gxb.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) throws IOException {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        System.out.println("服务器启动了...");

        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {
            // 监听，等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            // 就创建一个线程，与之通信（单独写一个方法）
            newCachedThreadPool.execute(() -> {
                // 可以和客户端通讯
                handler(socket);
            });
        }
    }

    //编写一个handler方法，和客户端通讯
    public static void handler(Socket socket) {
        try {
            System.out.println("Thread id = " + Thread.currentThread().getId() + ",Thread name = " +
                    Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            // 循环读取客户端发送的数据
            while (true) {
                System.out.println("Thread id = " + Thread.currentThread().getId() + ",Thread name = " +
                        Thread.currentThread().getName());
                int read = inputStream.read(bytes,0,bytes.length);
                if (read != -1) {
                    //输出客户端发送的数据
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
                System.out.println("关闭了和client的连接");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
