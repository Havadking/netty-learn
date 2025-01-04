package cn.havad.netty.c1;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: black-horse-netty
 * @description:
 * @author: Havad
 * @create: 2025-01-04 10:29
 **/

@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {

        // FileChannel
        try (FileChannel channel = new FileInputStream("/Users/macmini/IdeaProjects/black-horse-netty/1.nio/data.txt").getChannel()) {
            // get buffer
            ByteBuffer buffer = ByteBuffer.allocate(10);

            while (true) {
                // 从channel中读取数据，向buffer中写入
                int len = channel.read(buffer);
                log.info("读取到的字节数{}", len);
                if (len == -1) {
                    // 读取结束
                    break;
                }

                // 切换到读模式
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    log.info("读取的字节{}", (char) b);
                }

                // 切换回写模式
                buffer.clear();
            }

        } catch (IOException e) {
        }
    }
}
