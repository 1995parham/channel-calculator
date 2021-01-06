package com.zolaliran.channelcalculator.dao;

public class ChannelDaoFactory {
	public static ChannelDao getInstance() {
		return new JsonChannelDao();
	}
}
