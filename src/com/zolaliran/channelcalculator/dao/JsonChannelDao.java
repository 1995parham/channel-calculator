package com.zolaliran.channelcalculator.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.zolaliran.channelcalculator.controllers.ChannelList;

public class JsonChannelDao implements ChannelDao {

	@Override
	public void write(ChannelList channels, OutputStream oStream) {
		Gson gson = new Gson();
		String channelData = gson.toJson(channels);
		PrintWriter writer = new PrintWriter(oStream);
		writer.println(channelData);
		writer.close();
	}

	@Override
	public ChannelList read(InputStream iStream) throws IOException {
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				iStream));
		String channelsData = reader.readLine();
		reader.close();
		return gson.fromJson(channelsData, ChannelList.class);
	}
}
