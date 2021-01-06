package com.zolaliran.channelcalculator.view;

import com.zolaliran.channelcalculator.domain.Channel;

public class ChannelView {

	private Channel channel;

	public static String getNameAt(int index) {
		switch (index) {
		case 0:
			return "ID";
		case 1:
			return "Start Point ID";
		case 2:
			return "End Point ID";
		case 3:
			return "Length";
		case 4:
			return "Width";
		case 5:
			return "Height";
		case 6:
			return "FB";
		case 7:
			return "Discharge";
		case 8:
			return "Add Discharge";
		case 9:
			return "Total Discharge";
		case 10:
			return "Start Channel Bottom Elevation";
		case 11:
			return "End Channel Bottom Elevation";
		case 12:
			return "Channel Slope";
		case 13:
			return "Water Height";
		case 14:
			return "Velocity";
		case 15:
			return "Start Earth Elevation";
		case 16:
			return "End Earth Elevation";
		default:
			return "Error";
		}
	}

	public ChannelView(Channel channel) {
		this.channel = channel;
	}

	public Object getValueAt(int index) {
		switch (index) {
		case 0:
			return getId();
		case 1:
			return getStartPointId();
		case 2:
			return getEndPointId();
		case 3:
			return getLength();
		case 4:
			return getWidth();
		case 5:
			return getHieght();
		case 6:
			return getFB();
		case 7:
			return getDischarge();
		case 8:
			return getAddDischarge();
		case 9:
			return getTotalDischarge();
		case 10:
			return getStartChannelBottomElevation();
		case 11:
			return getEndChannelBottomElevation();
		case 12:
			return getChannelSlope();
		case 13:
			return getWaterHeight();
		case 14:
			return getVelocity();
		case 15:
			return getStartEarthElevation();
		case 16:
			return getEndEarthElevation();
		default:
			return null;
		}
	}

	private double getEndEarthElevation() {
		return channel.getEndEarthElevation();
	}

	private double getStartEarthElevation() {
		return channel.getStartEarthElevation();
	}

	public double getVelocity() {
		return channel.getVelocity();
	}

	public double getStartChannelBottomElevation() {
		return channel.getStartChannelBottomElevation();
	}

	public double getEndChannelBottomElevation() {
		return channel.getEndChannelBottomElevation();
	}

	public double getChannelSlope() {
		return channel.getChannelSlope();
	}

	public double getWaterHeight() {
		return channel.getWaterHeight();
	}

	public int getId() {
		return channel.getId();
	}

	public int getStartPointId() {
		return channel.getStartPointId();
	}

	public int getEndPointId() {
		return channel.getEndPointId();
	}

	public double getLength() {
		return channel.getLength();
	}

	public double getWidth() {
		return channel.getWidth();
	}

	public double getHieght() {
		return channel.getHeight();
	}

	public double getFB() {
		return channel.getFB();
	}

	public double getDischarge() {
		return channel.getDischarge();
	}

	public double getAddDischarge() {
		return channel.getAddDischarge();
	}

	public double getTotalDischarge() {
		return channel.getTotalDischage();
	}

}
