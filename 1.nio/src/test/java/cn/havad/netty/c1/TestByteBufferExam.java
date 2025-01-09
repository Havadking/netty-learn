package cn.havad.netty.c1;

import java.nio.ByteBuffer;

import static cn.havad.netty.c1.ByteBufferUtil.debugAll;

/**
 * @program: black-horse-netty
 * @description:
 * @author: Havad
 * @create: 2025-01-04 15:34
 **/

public class TestByteBufferExam {
    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);


    }

    private static void split(ByteBuffer source) {
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n') {
                int length = i + 1 - source.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                for (int i1 = 0; i1 < length; i1++) {
                    target.put(source.get());
                }
                debugAll(target);
            }

        }
        source.compact();
    }
}
