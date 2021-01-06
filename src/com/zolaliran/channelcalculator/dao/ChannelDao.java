package com.zolaliran.channelcalculator.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.zolaliran.channelcalculator.controllers.ChannelList;

public interface ChannelDao {
	void write(ChannelList channels, OutputStream oStream);

	ChannelList read(InputStream iStream) throws IOException;
}
