package com.ztgame.noark.core.lang;

import java.util.Arrays;

/**
 * ArrayQueue 采用循环数组实现.
 * <p>
 * 可应用于跑马灯公告中.
 * 
 * @param <E>
 *            队列保存类型
 * @author 小流氓<176543888@qq.com>
 */
public class ArrayQueue<E> {
	// 队列数组
	private final Object[] items;
	// 记录队列items下标
	private int putIndex;
	// 记录队列items中的元素个数
	private int count;

	/**
	 * 构造一个队列对象.
	 * @param capacity 队列大小
	 */
	public ArrayQueue(final int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("ArrayQueue capacity <= 0 ????");
		this.items = new Object[capacity];
	}

	/**
	 * 清空当前队列.
	 */
	public void clear() {
		putIndex = 0;
		count = 0;
		Arrays.fill(items, null);
	}

	/**
	 * Circularly increment i.
	 */
	private final int inc(int i) {
		return (++i == items.length) ? 0 : i;
	}

	/**
	 * 插入一个元素
	 */
	private void insert(E x) {
		items[putIndex] = x;
		putIndex = inc(putIndex);
		if (items.length > count) {
			count++;
		}
	}

	/**
	 * 添加元素到队列中，如果队列已满则替换第一个元素.
	 * @param targets 添加目标列表
	 */
	public void add(E... targets) {
		for (E e : targets) {
			this.insert(e);
		}
	}

	/**
	 * 返回当队列中所包含的元素个数
	 * @return 元素总数
	 */
	public int size() {
		return count;
	}

	/**
	 * 判断当前队列是否为空.
	 * @return 如果队列中没有任何元素则返回true,否则返回false
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * 转成化数组
	 * @return 如果当前为空队列，则返回空数组，否则返回当前队列所包含的元素数组
	 */
	public Object[] toArray() {
		Object[] ret = new Object[count];
		for (int i = (count == items.length) ? putIndex : 0, k = 0; k < count; i = inc(i), k++) {
			ret[k] = items[i];
		}
		return ret;
	}

	@Override
	public String toString() {
		return "ArrayQueue [items=" + Arrays.toString(this.toArray())
				+ ", putIndex=" + putIndex + ", count=" + count + "]";
	}

	/**
	 * 获取前几个元素.
	 * @param top 数量
	 * @return 元素数组
	 */
	public Object[] getTop(int top) {
		if(top > count) top = count;
		Object[] ret = new Object[top];
		for (int i = (count == items.length) ? putIndex : 0, k = 0; k < top; i = inc(i), k++) {
			ret[k] = items[i];
		}
		return ret;
	}
}