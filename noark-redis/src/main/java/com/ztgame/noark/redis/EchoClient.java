package com.ztgame.noark.redis;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class EchoClient {
	public static void main(String[] args) throws UnsupportedEncodingException {
		final int DEFAULT_PORT = 6666;
		final String IP = "192.168.85.153";
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		ByteBuffer helloBuffer = ByteBuffer.wrap((
				"*3\r\n" +
				
				"$3\r\n" +
				"SET\r\n" + //opcode
				"$5\r\n" +
				"mykey\r\n" +	//key
				"$9\r\n" +
				"小流氓\r\n").getBytes("UTF-8")); //value
		ByteBuffer randomBuffer;
		CharBuffer charBuffer;
		Charset charset = Charset.defaultCharset();
		CharsetDecoder decoder = charset.newDecoder();
		// create an asynchronous socket channel bound to the default group
		try (AsynchronousSocketChannel asynchronousSocketChannel = AsynchronousSocketChannel.open()) {
			
			
			
			if (asynchronousSocketChannel.isOpen()) {
				// set some options
				asynchronousSocketChannel.setOption(
						StandardSocketOptions.SO_RCVBUF, 128 * 1024);
				asynchronousSocketChannel.setOption(
						StandardSocketOptions.SO_SNDBUF, 128 * 1024);
				asynchronousSocketChannel.setOption(
						StandardSocketOptions.SO_KEEPALIVE, true);
				// connect this channel's socket
				Void connect = asynchronousSocketChannel.connect(
						new InetSocketAddress(IP, DEFAULT_PORT)).get();
				if (connect == null) {
					System.out.println("Local address: "
							+ asynchronousSocketChannel.getLocalAddress());
					// transmitting data
					asynchronousSocketChannel.write(helloBuffer).get();
					while (asynchronousSocketChannel.read(buffer).get() != -1) {
						buffer.flip();
						charBuffer = decoder.decode(buffer);
						System.out.println(charBuffer.toString());
						if (buffer.hasRemaining()) {
							buffer.compact();
						} else {
							buffer.clear();
						}
						int r = new Random().nextInt(100);
						if (r == 50) {
							System.out
									.println("50 was generated! Close the asynchronous socket channel!");
							break;
						} else {
							randomBuffer = ByteBuffer.wrap("Random number:"
									.concat(String.valueOf(r)).getBytes());
							asynchronousSocketChannel.write(randomBuffer).get();
						}
					}
				} else {
					System.out.println("The connection cannot be established!");
				}
			} else {
				System.out
						.println("The asynchronous socket channel cannot be opened!");
			}
		} catch (IOException | InterruptedException | ExecutionException ex) {
			System.err.println(ex);
		}
	}
}