package com.zolaliran.channelcalculator.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.zolaliran.channelcalculator.controllers.ChannelController;
import com.zolaliran.channelcalculator.view.ChannelView;

public class ChannelTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -6135708551919908267L;
	private ArrayList<ChannelView> channels;

	public ChannelTableModel() {
		update();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 18;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return ChannelView.getNameAt(columnIndex);
	}

	@Override
	public int getRowCount() {
		update();
		return channels.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return channels.get(rowIndex).getValueAt(columnIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	public void update() {
		this.channels = ChannelController.getInstance().view();
	}

}
