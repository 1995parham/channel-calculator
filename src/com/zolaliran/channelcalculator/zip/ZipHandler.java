package com.zolaliran.channelcalculator.zip;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipHandler {
	private String path;
	private ByteArrayOutputStream channels;
	private ByteArrayOutputStream project;
	private ZipOutputStream zos;
	private ZipFile file;

	public ZipHandler(String path) {
		this.path = path;
		channels = new ByteArrayOutputStream();
		project = new ByteArrayOutputStream();
	}

	public InputStream getChanneliStream() throws IOException {
		file = new ZipFile(path);
		return file.getInputStream(file.getEntry("channels"));
	}

	public InputStream getProjectiStream() throws IOException {
		file = new ZipFile(path);
		return file.getInputStream(file.getEntry("project"));
	}

	public OutputStream getChanneloStream() throws IOException {
		return channels;
	}

	public OutputStream getProjectoStream() throws IOException {
		return project;
	}

	public void close() throws IOException {
		zos = new ZipOutputStream(new FileOutputStream(path));
		zos.putNextEntry(new ZipEntry("channels"));
		zos.write(channels.toByteArray());
		zos.closeEntry();
		zos.putNextEntry(new ZipEntry("project"));
		zos.write(project.toByteArray());
		zos.closeEntry();
		zos.close();
	}

}
