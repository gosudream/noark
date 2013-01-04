package com.ztgame.noark.core.lang;

import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayQueueTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("test ArrayQueue");
	}

	@Test
	public void testAdd() {
		ArrayQueue<String> queues = new ArrayQueue<String>(5);
		
		for (int i = 0; i <= 100; i++) {
			queues.add(String.valueOf(i));
		}
		
		queues.add("鬼직책", "높직책");
		System.out.println(queues);
	}
}
