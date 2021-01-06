package com.zolaliran.channelcalculator.controllers;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.zolaliran.channelcalculator.bean.ProjectData;
import com.zolaliran.channelcalculator.dao.ChannelDao;
import com.zolaliran.channelcalculator.dao.ChannelDaoFactory;
import com.zolaliran.channelcalculator.dao.ProjectDao;
import com.zolaliran.channelcalculator.dao.ProjectDaoFactory;
import com.zolaliran.channelcalculator.log.DefaultLogger;
import com.zolaliran.channelcalculator.zip.ZipHandler;

public class ProjectController {
	private static ProjectController instance;

	private String path;
	private Logger logger;
	private double manningCoefficient;
	private double rainfallIntensity;
	private double Vmax;
	private double Vmin;

	public static ProjectController getInstance() {
		if (instance == null) {
			instance = new ProjectController();
		}
		return instance;
	}

	private ProjectController() {
		logger = DefaultLogger.getLogger(this.getClass());
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public double getManningCoefficient() {
		return manningCoefficient;
	}

	public void setManningCoefficient(double manningCoefficient) {
		this.manningCoefficient = manningCoefficient;
	}

	public double getRainfallIntensity() {
		return rainfallIntensity;
	}

	public void setRainfallIntensity(double rainfallIntensity) {
		this.rainfallIntensity = rainfallIntensity;
	}

	public double getVmax() {
		return Vmax;
	}

	public void setVmax(double vmax) {
		Vmax = vmax;
	}

	public double getVmin() {
		return Vmin;
	}

	public void setVmin(double vmin) {
		Vmin = vmin;
	}

	public boolean load() {
		ZipHandler handler = new ZipHandler(path);
		ChannelList channels = null;
		ProjectData data = null;
		try {
			ChannelDao dao = ChannelDaoFactory.getInstance();
			channels = dao.read(handler.getChanneliStream());
		} catch (IOException exception) {
			logger.log(Level.FATAL, "IO ERROR", exception);
			return false;
		}
		try {
			ProjectDao dao = ProjectDaoFactory.getInstance();
			data = dao.read(handler.getProjectiStream());
		} catch (IOException exception) {
			logger.log(Level.FATAL, "IO ERROR", exception);
			return false;
		}
		ChannelController.getInstance().load(channels);
		rainfallIntensity = data.getRainfallIntensity();
		manningCoefficient = data.getManningCoefficient();
		Vmax = data.getVmax();
		Vmin = data.getVmin();
		return true;
	}

	public boolean save() {
		ZipHandler handler = new ZipHandler(path);
		ProjectData data = new ProjectData();
		data.setManningCoefficient(manningCoefficient);
		data.setRainfallIntensity(rainfallIntensity);
		data.setVmax(Vmax);
		data.setVmin(Vmin);
		try {
			ChannelDao dao = ChannelDaoFactory.getInstance();
			ChannelList channels = ChannelController.getInstance().save();
			dao.write(channels, handler.getChanneloStream());
		} catch (IOException exception) {
			logger.log(Level.FATAL, "IO ERROR", exception);
			return false;
		}
		try {
			ProjectDao dao = ProjectDaoFactory.getInstance();
			dao.write(data, handler.getProjectoStream());
		} catch (IOException exception) {
			logger.log(Level.FATAL, "IO ERROR", exception);
			return false;
		}
		try {
			handler.close();
		} catch (IOException exception) {
			logger.log(Level.FATAL, "IO ERROR", exception);
			return false;
		}
		return true;
	}

}
