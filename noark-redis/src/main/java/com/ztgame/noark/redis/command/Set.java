package com.ztgame.noark.redis.command;

public class Set extends Command {
	private String key;
	private String value;
	
	public Set(String key, String value) {
		super("SET", "0.0.7");
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}
