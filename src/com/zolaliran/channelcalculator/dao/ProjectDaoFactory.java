package com.zolaliran.channelcalculator.dao;

public class ProjectDaoFactory {
	public static ProjectDao getInstance() {
		return new JsonProjectDao();
	}
}
