package com.ztgame.noark.redis;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class RedisTest {

	private static Redis redis;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		redis = new Redis("192.168.85.153", 6666, null, 11);
	}

	@Test
	public void test() throws IOException {
		redis.set("", "");
		
	}
	@Test
	public void testCopy() throws IOException{
		
	}
	@Test
	public void testCopy1() throws IOException{
	}
	
}
