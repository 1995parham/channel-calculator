package com.zolaliran.channelcalculator.domain;

import java.util.Iterator;
import java.util.List;

import com.zolaliran.channelcalculator.controllers.PointController;
import com.zolaliran.channelcalculator.controllers.ProjectController;

public class Channel {
	private int id;
	private int startPointId;
	private int endPointId;
	private double length;
	private List<Double> areas;
	private List<Double> peneterations;
	private double width;
	private double height;
	private double FB;

	private double startEarthElevation;
	private double endEarthElevation;

	private double discharge;
	private double addDischarge;
	private double totalDischage;
	private double endChannelBottomElevation;
	private double startChannelBottomElevation;
	private double channelSlope;
	private double waterHeight;
	private double velocity;

	public Channel(int id, int startPointId, int endPointId, double length,
			List<Double> areas, List<Double> peneterations, double width,
			double height, double fB) {
		super();
		this.id = id;
		this.startPointId = startPointId;
		this.endPointId = endPointId;
		this.length = length;
		this.areas = areas;
		this.peneterations = peneterations;
		this.width = width;
		this.height = height;
		this.FB = fB;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStartPointId() {
		return startPointId;
	}

	public void setStartPointId(int startPointId) {
		this.startPointId = startPointId;
	}

	public int getEndPointId() {
		return endPointId;
	}

	public void setEndPointId(int endPointId) {
		this.endPointId = endPointId;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public List<Double> getAreas() {
		return areas;
	}

	public void setAreas(List<Double> areas) {
		this.areas = areas;
	}

	public List<Double> getPeneterations() {
		return peneterations;
	}

	public void setPeneterations(List<Double> peneterations) {
		this.peneterations = peneterations;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getFB() {
		return FB;
	}

	public void setFB(double fB) {
		FB = fB;
	}

	public double getDischarge() {
		discharge = 0;
		for (int i = 0; i < areas.size(); i++) {
			discharge += areas.get(i).doubleValue() * peneterations.get(i)
					* ProjectController.getInstance().getRainfallIntensity();
		}
		return discharge;
	}

	public void setDischarge(double discharge) {
		this.discharge = discharge;
	}

	public double getAddDischarge() {
		addDischarge = 0;
		Point startPoint = PointController.getInstance().getPoint(startPointId);
		Iterator<Channel> iterator = startPoint.getEndChannelsIterator();
		while (iterator.hasNext()) {
			addDischarge += iterator.next().getTotalDischage();
		}
		return addDischarge;
	}

	public void setAddDischarge(double addDischarge) {
		this.addDischarge = addDischarge;
	}

	public double getTotalDischage() {
		totalDischage = 0;
		totalDischage = getAddDischarge() + getDischarge();
		return totalDischage;
	}

	public void setTotalDischage(double totalDischage) {
		this.totalDischage = totalDischage;
	}

	public double getStartChannelBottomElevation() {
		Point point = PointController.getInstance().getPoint(startPointId);
		startChannelBottomElevation = point.getEarthElevation() - height;
		return startChannelBottomElevation;
	}

	public double getEndChannelBottomElevation() {
		Point point = PointController.getInstance().getPoint(endPointId);
		endChannelBottomElevation = point.getEarthElevation() - height;
		return endChannelBottomElevation;
	}

	public double getChannelSlope() {
		channelSlope = (endChannelBottomElevation - startChannelBottomElevation)
				/ length;
		return channelSlope;
	}

	public double getWaterHeight() {
		return waterHeight;
	}

	public double getVelocity() {
		double n = ProjectController.getInstance().getManningCoefficient();
		double b = width;
		double h = waterHeight;
		double s = channelSlope;
		velocity = (1 / n) * Math.pow((b * h), 2 / 3)
				* Math.pow((1 / (2 * h + b)), 2 / 3) * Math.pow(s, 1 / 2);
		return velocity;
	}

	public double getStartEarthElevation() {
		double startEarthElevation = PointController.getInstance()
				.getPoint(startPointId).getEarthElevation();
		if (startEarthElevation != -1) {
			this.startEarthElevation = startEarthElevation;
		} else {
			PointController.getInstance().getPoint(startPointId)
					.setEarthElevation(this.startEarthElevation);
		}
		return this.startEarthElevation;
	}

	public void setStartEarthElevation(double startEarthElevation) {
		this.startEarthElevation = startEarthElevation;
		PointController.getInstance().getPoint(startPointId)
				.setEarthElevation(startEarthElevation);
	}

	public double getEndEarthElevation() {
		double endEarthElevation = PointController.getInstance()
				.getPoint(endPointId).getEarthElevation();
		if (endEarthElevation != -1) {
			this.endEarthElevation = endEarthElevation;
		} else {
			PointController.getInstance().getPoint(endPointId)
					.setEarthElevation(this.endEarthElevation);
		}
		return this.endEarthElevation;
	}

	public void setEndEarthElevation(double endEarthElevation) {
		this.endEarthElevation = endEarthElevation;
		PointController.getInstance().getPoint(endPointId)
				.setEarthElevation(endEarthElevation);
	}

}
