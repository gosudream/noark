package com.ztgame.noark.redis.exception;

/**
 * Redis异常.
 * 
 * @author 小流氓<176543888@qq.com>
 */
public class RedisException extends RuntimeException {

	private static final long serialVersionUID = 1905566825167606286L;

	public RedisException(String message, Throwable cause) {
		super(message, cause);
	}
}
