package com.ztgame.noark.redis;

public class RedisException extends RuntimeException {

	public RedisException(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = 2085207902625881057L;

}
