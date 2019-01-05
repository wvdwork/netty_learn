package com.wvd.netty.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class BufferTest {

    public static void main(String[] args) {
        //创建指定长度缓冲区
        IntBuffer intBuffer = IntBuffer.allocate(10);
        int[] array = new int[]{3, 5, 1};

        //使用数组来创建一个缓冲区视图
        intBuffer = intBuffer.wrap(array);

        //利用数组来创建某一个区间的视图
//        intBuffer = intBuffer.wrap(array,0, 2);

        //对缓冲区某个位置上的值进行修改
        intBuffer.put(0, 7);

        //遍历缓冲区中的值
        System.out.println(" 缓冲区中的值如下: ");

        for(int i = 0; i < intBuffer.limit(); i++) {
            System.out.println(intBuffer.get());
        }

        System.out.println(intBuffer);

        IntBuffer intBuffer2 = intBuffer.duplicate();

        intBuffer.flip();
//        intBuffer.clear();
        System.out.println("buffer  || " + intBuffer);
        System.out.println("buffer2  || " + intBuffer2);
    }
}
