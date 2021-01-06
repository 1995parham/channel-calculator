package com.zolaliran.channelcalculator.bean;

import java.util.List;

public class BuildData {

	private int id;
	private int startPointId;
	private int endPointId;
	private double startEarthElevation;
	private double endEarthElevation;
	private double length;
	private List<Double> areas;
	private List<Double> peneterations;
	private double width;
	private double height;
	private double FB;

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

	public double getStartEarthElevation() {
		return startEarthElevation;
	}

	public void setStartEarthElevation(double startEarthElevation) {
		this.startEarthElevation = startEarthElevation;
	}

	public double getEndEarthElevation() {
		return endEarthElevation;
	}

	public void setEndEarthElevation(double endEarthElevation) {
		this.endEarthElevation = endEarthElevation;
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

}
