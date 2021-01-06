package com.zolaliran.channelcalculator.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class DefaultLogger {
	private static DefaultLogger instance;

	private Logger logger;

	public static DefaultLogger getInstance() {
		if (instance == null) {
			instance = new DefaultLogger();
		}
		return instance;
	}

	public static Logger getLogger(Class<?> clazz) {
		return Logger.getLogger(clazz);

	}

	private DefaultLogger() {
		logger = Logger.getLogger("Main-Logger");
	}

	public void logException(Exception exception) {
		logger.log(Level.ERROR, "", exception);
	}
}
