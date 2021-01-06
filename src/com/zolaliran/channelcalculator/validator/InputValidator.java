package com.zolaliran.channelcalculator.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.zolaliran.channelcalculator.log.DefaultLogger;

public class InputValidator {
	public static Logger logger = DefaultLogger.getLogger(InputValidator.class);

	public static String validate(String input) {
		if (input != null && input.length() != 0) {
			return input;
		}
		logger.log(Level.ERROR, "String [" + input + "] is not valid String");
		return "";
	}

	public static double toDouble(String input) {
		input = validate(input);
		double value = 0;
		try {
			value = Double.parseDouble(input);
			return value;
		} catch (NumberFormatException exception) {
			logger.log(Level.ERROR, "String [" + input
					+ "] is not valid Double");
			return -1;
		}
	}

	public static int toInt(String input) {
		input = validate(input);
		int value = 0;
		try {
			value = Integer.parseInt(input);
			return value;
		} catch (NumberFormatException exception) {
			logger.log(Level.ERROR, "String [" + input + "] is not valid Int");
			return -1;
		}
	}

	public static List<Double> toDoubleArray(String input) {
		String[] inputs = input.split(" ");
		List<Double> values = new ArrayList<Double>();
		for (int i = 0; i < inputs.length; i++) {
			double value = toDouble(inputs[i]);
			if (value == -1) {
				logger.log(Level.ERROR, "String [" + input
						+ "] is not valid Double Array");
				return null;
			}
			values.add(value);
		}
		return values;
	}

	public static List<Integer> toIntArray(String input) {
		String[] inputs = input.split(" ");
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < inputs.length; i++) {
			int value = toInt(inputs[i]);
			if (value == -1) {
				logger.log(Level.ERROR, "String [" + input
						+ "] is not valid Int Array");
				return null;
			}
			values.add(value);
		}
		return values;
	}
}
