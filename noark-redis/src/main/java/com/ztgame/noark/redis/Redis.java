package com.ztgame.noark.redis;


/**
 * Redis 操作辅助类.
 * <p>
 * 1.关键字（Keys）<br>
 * 
 *  字符串（String） 哈希（Hashs） 列表（Lists） 集合（Sets） 有序集合（Sorted Sets）发布/订阅（Pub/Sub） 事务（Transactions） 脚本（Scripting） 连接（Connection） 服务（Server）
 * 
 * @author 小流氓<176543888@qq.com>
 * @version 1.0.0 2012-12-22
 */
public class Redis {

	/**
	 * 构造Redis操作实例.
	 * @param host 地址
	 * @param port 端口
	 * @param password 密码
	 * @param dbIndex DB编号
	 */
	public Redis(String host, int port, String password, int dbIndex) {
	}

	/**
	 * 测试主机服务是否正常启动.
	 * 
	 * @return 如果正常启动，则返回true，否则返回false
	 */
	public boolean test() {
		return false;
	}

	/**
	 * 删除指定的key，如果删除的key不存在，则直接忽略。
	 * <p>
	 * 时间复杂度：<br>
	 * O(n)N为要移除的key的数量。<br>
	 * 移除单个字符串类型的key，时间复杂度为O(1)。<br>
	 * 移除单个列表、集合、有序集合或哈希表类型的key，时间复杂度为O(M)，M为以上数据结构内的元素数量。
	 * 
	 * @param keys key列表
	 * @return 被删除的keys的数量
	 * @since Redis1.0.0
	 */
	public Long del(String... keys) {
		return 0L;
	}
	
	/**
	 * 
	 * 获取key的有效时间。
	 * <p>
	 * 时间复杂度: O(1)
	 * 
	 * @param key Key
	 * @return 如果此Key有设置超时，则返回剩余的时间，单位秒，否则返回-1
	 * @since Redis1.0.0
	 */
	public Long ttl(String key) {
		return 0L;
	}
	/**
	 * 设置一个key的value值。
	 * <p>
	 * 将key和value对应。如果key已经存在了，它会被覆盖，而不管它是什么类型。<br>
	 * 时间复杂度: O(1). 
	 * 
	 * @param key
	 * @param value
	 * @return 总是OK，因为SET不会失败。
	 * @since 0.0.7
	 */
	public String set(final String key, final String value) {
		//获取一个实例
		
		//操作
		
		//归还实例
		
		return "OK";
	}
}
