package com.wvd.netty.nio.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        File file = new File("D:/a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileChannel in = new FileInputStream("D://a.txt").getChannel();
        FileChannel out = new FileOutputStream("D:/a.txt", true).getChannel();



        byteBuffer.clear();
        int len = in.read(byteBuffer);
        System.out.print(new String(byteBuffer.array(), 0, len));

        System.out.println("----------------");

        byteBuffer.clear();

        out.write(byteBuffer.wrap("测试一个了.....".getBytes()));

        byteBuffer.flip();
        byteBuffer.clear();
        int len2 = in.read(byteBuffer);
        System.out.print(new String(byteBuffer.array(), 0, len2));

        in.close();
        out.close();
    }
}
