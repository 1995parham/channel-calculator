package com.zolaliran.channelcalculator.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Point {
	private int id;
	private double earthElevation;
	private ArrayList<Channel> startChannels;
	private ArrayList<Channel> endChannels;

	public Point(int id, double earthElevation) {
		super();
		this.id = id;
		this.earthElevation = earthElevation;
		this.startChannels = new ArrayList<Channel>();
		this.endChannels = new ArrayList<Channel>();
	}

	public Point(int id) {
		this(id, -1);
	}

	public void addStartChannel(Channel channel) {
		startChannels.add(channel);
	}

	public int countStartChannels() {
		return startChannels.size();
	}

	public Iterator<Channel> getStartChannelsIterator() {
		return startChannels.iterator();
	}

	public void addEndChannel(Channel channel) {
		endChannels.add(channel);
	}

	public int countEndChannels() {
		return endChannels.size();
	}

	public Iterator<Channel> getEndChannelsIterator() {
		return endChannels.iterator();
	}

	public int getId() {
		return id;
	}

	public double getEarthElevation() {
		return earthElevation;
	}

	public void setEarthElevation(double earthElevation) {
		this.earthElevation = earthElevation;
	}

	public ArrayList<Channel> getStartChannels() {
		return startChannels;
	}

	public void setStartChannels(ArrayList<Channel> startChannels) {
		this.startChannels = startChannels;
	}

	public ArrayList<Channel> getEndChannels() {
		return endChannels;
	}

	public void setEndChannels(ArrayList<Channel> endChannels) {
		this.endChannels = endChannels;
	}

}
