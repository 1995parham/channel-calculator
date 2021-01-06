package com.zolaliran.channelcalculator.controllers;

import java.util.HashMap;

import com.zolaliran.channelcalculator.domain.Point;

public class PointController {
	private static PointController instance;

	private HashMap<Integer, Point> points;

	public static PointController getInstance() {
		if (instance == null) {
			instance = new PointController();
		}
		return instance;
	}

	private PointController() {
		points = new HashMap<Integer, Point>();
	}

	public Point getPoint(int id, boolean createNew) {
		if (createNew) {
			if (points.containsKey(id)) {
				return points.get(id);
			} else {
				addPoint(new Point(id));
				return points.get(id);
			}
		} else {
			return points.get(id);
		}
	}

	public Point getPoint(int id) {
		return getPoint(id, true);
	}

	public boolean containsPoint(int id) {
		return points.containsKey(id);
	}

	public Point removePoint(int id) {
		return points.remove(id);
	}

	private void addPoint(Point point) {
		points.put(point.getId(), point);
	}

}
