package com.zolaliran.channelcalculator.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.zolaliran.channelcalculator.controllers.ChannelController;
import com.zolaliran.channelcalculator.validator.ChannelValidator;

public class ChannelTable extends JTable {

	private static final long serialVersionUID = 2901802490286046346L;

	private ChannelTableModel model;
	private JPopupMenu popupMenu;
	private JMenuItem editMenuItem;

	public ChannelTable() {
		model = new ChannelTableModel();
		setModel(model);

		popupMenu = new JPopupMenu();
		add(popupMenu);
		setComponentPopupMenu(popupMenu);

		editMenuItem = new JMenuItem("Edit");
		editMenuItem.addActionListener(new EditHandler());
		popupMenu.add(editMenuItem);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row,
			int column) {
		Component component = super.prepareRenderer(renderer, row, column);
		if (!isRowSelected(row)) {
			if (ChannelValidator.isValid(ChannelController.getInstance()
					.getChannel(row))) {
				component.setBackground(Color.ORANGE);
			} else {
				component.setBackground(Color.RED);
			}
		}
		return component;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public void refresh() {
		model.update();
		model.fireTableStructureChanged();
	}

	private class EditHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			int index = ChannelTable.this.getSelectedRow();
			new EditChannelDialog(index, ChannelTable.this.getParent())
					.setVisible(true);
		}
	}

}
