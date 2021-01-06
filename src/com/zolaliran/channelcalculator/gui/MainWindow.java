package com.zolaliran.channelcalculator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;

import com.zolaliran.channelcalculator.controllers.ProjectController;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1644673630235360505L;

	private JLabel logoImage;
	private JPanel contentPane;
	private ChannelTable channelTable;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu channelMenu;
	private JMenu tableMenu;
	private JMenuItem buildChannelItem;
	private JMenuItem refreshTableItem;
	private JMenuItem saveItem;

	public MainWindow() {
		super("Channel Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane = new JPanel();
		contentPane.setLayout(sl_contentPane);
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		new BuildProjectDialog(this).setVisible(true);

		channelTable = new ChannelTable();
		JScrollPane channelTablePane = new JScrollPane(channelTable);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, channelTablePane, 0,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, channelTablePane, 0,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, channelTablePane, 0,
				SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, channelTablePane, 50,
				SpringLayout.NORTH, contentPane);
		contentPane.add(channelTablePane);

		logoImage = new JLabel(new ImageIcon("images/logo.jpg"));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, logoImage, 0,
				SpringLayout.NORTH, channelTablePane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, logoImage, 0,
				SpringLayout.NORTH, contentPane);
		contentPane.add(logoImage);

		buildChannelItem = new JMenuItem("Build Channel");
		buildChannelItem.addActionListener(new BuildChannelHandler());
		buildChannelItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				KeyEvent.ALT_DOWN_MASK));

		refreshTableItem = new JMenuItem("Refresh");
		refreshTableItem.addActionListener(new RefreshTableHanler());

		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new SaveHandler());

		channelMenu = new JMenu("Channel");
		channelMenu.add(buildChannelItem);

		fileMenu = new JMenu("File");
		fileMenu.add(saveItem);

		tableMenu = new JMenu("Table");
		tableMenu.add(refreshTableItem);

		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(channelMenu);
		menuBar.add(tableMenu);
		setJMenuBar(menuBar);
	}

	@Override
	public void repaint() {
		channelTable.refresh();
		super.repaint();
	}

	private class BuildChannelHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			new BuildChannelDialog(MainWindow.this).setVisible(true);
		}

	}

	private class RefreshTableHanler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			channelTable.refresh();
		}
	}

	private class SaveHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (ProjectController.getInstance().save()) {
				JOptionPane.showMessageDialog(MainWindow.this,
						"Save Complete!!!", "Save",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(MainWindow.this,
						"Save Failed....We sorry !!! see log for details",
						"Save", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
