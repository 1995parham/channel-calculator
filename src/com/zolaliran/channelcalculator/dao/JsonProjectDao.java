package com.zolaliran.channelcalculator.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.zolaliran.channelcalculator.bean.ProjectData;

public class JsonProjectDao implements ProjectDao {

	@Override
	public void write(ProjectData data, OutputStream oStream) {
		Gson gson = new Gson();
		String projectData = gson.toJson(data);
		System.out.println(projectData);
		PrintWriter writer = new PrintWriter(oStream);
		writer.println(projectData);
		writer.close();
	}

	@Override
	public ProjectData read(InputStream iStream) throws IOException {
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				iStream));
		String projectData = reader.readLine();
		reader.close();
		return gson.fromJson(projectData, ProjectData.class);

	}

}
