package cn.havad.netty.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @program: black-horse-netty
 * @description: \
 * @author: Havad
 * @create: 2025-01-08 16:17
 **/

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 7496));
        System.out.println("waiting...");
    }
}
