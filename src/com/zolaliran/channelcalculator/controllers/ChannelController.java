package com.zolaliran.channelcalculator.controllers;

import java.util.ArrayList;
import java.util.Iterator;

import com.zolaliran.channelcalculator.bean.BuildData;
import com.zolaliran.channelcalculator.domain.Channel;
import com.zolaliran.channelcalculator.domain.Point;
import com.zolaliran.channelcalculator.view.ChannelView;

public class ChannelController implements Iterable<Channel> {
	private static ChannelController instance;

	private ChannelList channels;

	public static ChannelController getInstance() {
		if (instance == null) {
			instance = new ChannelController();
		}
		return instance;
	}

	private ChannelController() {
		channels = new ChannelList();
	}

	public boolean buildChannel(BuildData data) {
		Point startPoint = PointController.getInstance().getPoint(
				data.getStartPointId());
		Point endPoint = PointController.getInstance().getPoint(
				data.getEndPointId());
		if (startPoint.getEarthElevation() != -1
				&& startPoint.getEarthElevation() != data
						.getStartEarthElevation()) {
			return false;
		} else {
			startPoint.setEarthElevation(data.getStartEarthElevation());
		}
		if (endPoint.getEarthElevation() != -1
				&& endPoint.getEarthElevation() != data.getEndEarthElevation()) {
			return false;
		} else {
			endPoint.setEarthElevation(data.getEndEarthElevation());
		}
		if (data.getPeneterations().size() != data.getAreas().size()) {
			return false;
		}
		Channel channel = new Channel(data.getId(), data.getStartPointId(),
				data.getEndPointId(), data.getLength(), data.getAreas(),
				data.getPeneterations(), data.getWidth(), data.getHeight(),
				data.getFB());
		channels.add(channel);
		startPoint.addStartChannel(channel);
		endPoint.addEndChannel(channel);
		return true;
	}

	private boolean buildChannel(Channel channel) {
		Point startPoint = PointController.getInstance().getPoint(
				channel.getStartPointId());
		Point endPoint = PointController.getInstance().getPoint(
				channel.getEndPointId());
		channel.getStartEarthElevation();
		channel.getEndEarthElevation();
		channels.add(channel);
		startPoint.addStartChannel(channel);
		endPoint.addEndChannel(channel);
		return true;

	}

	@Override
	public Iterator<Channel> iterator() {
		return this.channels.iterator();
	}

	public Channel getChannel(int index) {
		return channels.get(index);
	}

	public void load(ChannelList channels) {
		this.channels.clear();
		for (Channel channel : channels) {
			buildChannel(channel);
		}
		channels.clear();
	}

	public ChannelList save() {
		return this.channels;
	}

	public ArrayList<ChannelView> view() {
		ArrayList<ChannelView> views = new ArrayList<ChannelView>();
		for (int i = 0; i < channels.size(); i++) {
			views.add(new ChannelView(channels.get(i)));
		}
		return views;
	}

}
