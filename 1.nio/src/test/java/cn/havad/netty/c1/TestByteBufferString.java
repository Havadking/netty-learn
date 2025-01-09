package cn.havad.netty.c1;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static cn.havad.netty.c1.ByteBufferUtil.debugAll;

/**
 * @program: black-horse-netty
 * @description:
 * @author: Havad
 * @create: 2025-01-04 15:09
 **/

public class TestByteBufferString {
    public static void main(String[] args) {
        // String -> ByteBuffer

        // 1. getBytes() 生成的还是写模式的buffer
        ByteBuffer buffer1 = ByteBuffer.allocate(16);
        buffer1.put("hello".getBytes());
        debugAll(buffer1);

        // 2. Charset (主要用这个) 生成的就是读模式的buffer
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("hello");
        debugAll(buffer2);

        // 3. wrap() 生成的就是读模式的buffer
        ByteBuffer buffer3 = ByteBuffer.wrap("hello".getBytes());
        debugAll(buffer3);

        // ByteBuffer -> String

        // 1, charset
        String str1 = StandardCharsets.UTF_8.decode(buffer2).toString();
        System.out.println(str1);

        // 注意，如果转换buffer1，需要现将其改为读模式
        buffer1.flip();
        String str2 = StandardCharsets.UTF_8.decode(buffer1).toString();
        System.out.println(str2);
    }
}
