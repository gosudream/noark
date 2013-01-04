package com.ztgame.noark.redis.command;

public class Command {
	private final String opcode;
	private final String version;

	public Command(String opcode, String version) {
		this.opcode = opcode;
		this.version = version;
	}

	public String getOpcode() {
		return opcode;
	}

	public String getVersion() {
		return version;
	}
	
}
