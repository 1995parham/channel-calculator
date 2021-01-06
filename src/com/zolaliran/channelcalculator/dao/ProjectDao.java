package com.zolaliran.channelcalculator.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.zolaliran.channelcalculator.bean.ProjectData;

public interface ProjectDao {
	void write(ProjectData data, OutputStream oStream);

	ProjectData read(InputStream iStream) throws IOException;
}
