package cn.havad.netty.c4;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static cn.havad.netty.c1.ByteBufferUtil.debugRead;

/**
 * @program: black-horse-netty
 * @description:
 * @author: Havad
 * @create: 2025-01-08 16:13
 **/

@Slf4j
public class Server {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16);

        ServerSocketChannel scc = ServerSocketChannel.open();

        scc.bind(new InetSocketAddress(7496));

        List<SocketChannel> channels = new ArrayList<>();

        while (true) {
            log.debug("connecting...");
            SocketChannel sc = scc.accept();
            log.debug("connected... {}", sc);
            channels.add(sc);

            for (SocketChannel channel : channels) {
                log.debug("before read... {}", channel);
                channel.read(buffer);
                buffer.flip();
                debugRead(buffer);
                buffer.clear();
                log.debug("after read... {}", buffer);
            }
        }
    }
}
