package com.zolaliran.channelcalculator.validator;

import com.zolaliran.channelcalculator.controllers.ProjectController;
import com.zolaliran.channelcalculator.domain.Channel;

public class ChannelValidator {
	public static boolean isValid(Channel channel) {
		double height = channel.getHeight();
		double V = channel.getVelocity();
		double FB = channel.getFB();
		double waterHeight = channel.getWaterHeight();
		if (FB + waterHeight > height) {
			return false;
		}
		if (V > ProjectController.getInstance().getVmax()) {
			return false;
		}
		if (V < ProjectController.getInstance().getVmin()) {
			return false;
		}
		return true;
	}
}
