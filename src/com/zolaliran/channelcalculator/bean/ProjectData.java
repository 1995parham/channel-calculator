package com.zolaliran.channelcalculator.bean;

public class ProjectData {

	private double manningCoefficient;
	private double rainfallIntensity;
	private double Vmax;
	private double Vmin;

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
}
