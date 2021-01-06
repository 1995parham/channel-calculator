package com.zolaliran.channelcalculator.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.zolaliran.channelcalculator.bean.BuildData;
import com.zolaliran.channelcalculator.controllers.ChannelController;
import com.zolaliran.channelcalculator.validator.InputValidator;

public class BuildChannelDialog extends JDialog {

	private static final long serialVersionUID = -6751516432377356638L;

	private JPanel contentPane;
	private JButton buildButton;
	private JButton cancelButton;
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel startPointIdLabel;
	private JTextField startPointIdTextField;
	private JLabel endPointIdLabel;
	private JTextField endPointIdTextField;
	private JLabel startEarthElevationLabel;
	private JTextField startEarthElevationTextField;
	private JLabel endEarthElevationLabel;
	private JTextField endEarthElevationTextField;
	private JLabel lengthLabel;
	private JTextField lengthTextField;
	private JLabel widthLabel;
	private JTextField widthTextField;
	private JLabel heightLabel;
	private JTextField heightTextField;
	private JLabel FBLabel;
	private JTextField FBTextField;
	private JLabel peneterationsLabel;
	private JTextField peneterationsTextField;
	private JLabel areasLabel;
	private JTextField areasTextField;

	public BuildChannelDialog(JFrame owner) {
		super(owner, "Build Channel");
		setSize(new Dimension(400, 500));
		setLocationRelativeTo(owner);
		setModal(true);
		contentPane = new JPanel();
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		setContentPane(contentPane);

		buildButton = new JButton("Build");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, buildButton, -10,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, buildButton, 100,
				SpringLayout.WEST, contentPane);
		buildButton.addActionListener(new BuildHandler());
		contentPane.add(buildButton);

		cancelButton = new JButton("Cancel");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cancelButton, -10,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, cancelButton, 20,
				SpringLayout.EAST, buildButton);
		cancelButton.addActionListener(new cancelHandler());
		contentPane.add(cancelButton);

		idLabel = new JLabel("ID:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, idLabel, 20,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, idLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(idLabel);

		idTextField = new JTextField(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, idTextField, 20,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, idTextField, -10,
				SpringLayout.EAST, contentPane);
		contentPane.add(idTextField);

		startPointIdLabel = new JLabel("Start Point ID:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, startPointIdLabel, 20,
				SpringLayout.NORTH, idLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, startPointIdLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(startPointIdLabel);

		startPointIdTextField = new JTextField(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, startPointIdTextField,
				20, SpringLayout.NORTH, idTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, startPointIdTextField,
				-10, SpringLayout.EAST, contentPane);
		contentPane.add(startPointIdTextField);

		endPointIdLabel = new JLabel("End Point ID:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, endPointIdLabel, 20,
				SpringLayout.NORTH, startPointIdLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, endPointIdLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(endPointIdLabel);

		endPointIdTextField = new JTextField(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, endPointIdTextField,
				20, SpringLayout.NORTH, startPointIdTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, endPointIdTextField,
				-10, SpringLayout.EAST, contentPane);
		contentPane.add(endPointIdTextField);

		startEarthElevationLabel = new JLabel("Start Earth Elevation:");
		sl_contentPane.putConstraint(SpringLayout.NORTH,
				startEarthElevationLabel, 20, SpringLayout.NORTH,
				endPointIdLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST,
				startEarthElevationLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(startEarthElevationLabel);

		startEarthElevationTextField = new JTextField(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH,
				startEarthElevationTextField, 20, SpringLayout.NORTH,
				endPointIdTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST,
				startEarthElevationTextField, -10, SpringLayout.EAST,
				contentPane);
		contentPane.add(startEarthElevationTextField);

		endEarthElevationLabel = new JLabel("End Earth Elevation:");
		sl_contentPane.putConstraint(SpringLayout.NORTH,
				endEarthElevationLabel, 20, SpringLayout.NORTH,
				startEarthElevationLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, endEarthElevationLabel,
				10, SpringLayout.WEST, contentPane);
		contentPane.add(endEarthElevationLabel);

		endEarthElevationTextField = new JTextField(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH,
				endEarthElevationTextField, 20, SpringLayout.NORTH,
				startEarthElevationTextField);
		sl_contentPane
				.putConstraint(SpringLayout.EAST, endEarthElevationTextField,
						-10, SpringLayout.EAST, contentPane);
		contentPane.add(endEarthElevationTextField);

		lengthLabel = new JLabel("Length:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lengthLabel, 20,
				SpringLayout.NORTH, endEarthElevationLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lengthLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(lengthLabel);

		lengthTextField = new JTextField(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lengthTextField, 20,
				SpringLayout.NORTH, endEarthElevationTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, lengthTextField, -10,
				SpringLayout.EAST, contentPane);
		contentPane.add(lengthTextField);

		widthLabel = new JLabel("Width:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, widthLabel, 20,
				SpringLayout.NORTH, lengthLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, widthLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(widthLabel);

		widthTextField = new JTextField(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, widthTextField, 20,
				SpringLayout.NORTH, lengthTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, widthTextField, -10,
				SpringLayout.EAST, contentPane);
		contentPane.add(widthTextField);

		FBLabel = new JLabel("FB:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, FBLabel, 20,
				SpringLayout.NORTH, widthLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, FBLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(FBLabel);

		FBTextField = new JTextField(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, FBTextField, 20,
				SpringLayout.NORTH, widthTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, FBTextField, -10,
				SpringLayout.EAST, contentPane);
		contentPane.add(FBTextField);

		heightLabel = new JLabel("Height:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, heightLabel, 20,
				SpringLayout.NORTH, FBLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, heightLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(heightLabel);

		heightTextField = new JTextField(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, heightTextField, 20,
				SpringLayout.NORTH, FBTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, heightTextField, -10,
				SpringLayout.EAST, contentPane);
		contentPane.add(heightTextField);

		peneterationsLabel = new JLabel("Peneterations:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, peneterationsLabel,
				20, SpringLayout.NORTH, heightLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, peneterationsLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(peneterationsLabel);

		peneterationsTextField = new JTextField(20);
		sl_contentPane
				.putConstraint(SpringLayout.NORTH, peneterationsTextField, 20,
						SpringLayout.NORTH, heightTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, peneterationsTextField,
				-10, SpringLayout.EAST, contentPane);
		contentPane.add(peneterationsTextField);

		areasLabel = new JLabel("Areas:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, areasLabel, 20,
				SpringLayout.NORTH, peneterationsLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, areasLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(areasLabel);

		areasTextField = new JTextField(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, areasTextField, 20,
				SpringLayout.NORTH, peneterationsTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, areasTextField, -10,
				SpringLayout.EAST, contentPane);
		contentPane.add(areasTextField);
	}

	private class BuildHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			int id = InputValidator.toInt(idTextField.getText());
			int startPointId = InputValidator.toInt(startPointIdTextField
					.getText());
			int endPointId = InputValidator
					.toInt(endPointIdTextField.getText());
			double startEarthElevation = InputValidator
					.toDouble(startEarthElevationTextField.getText());
			double endEarthElevation = InputValidator
					.toDouble(endEarthElevationTextField.getText());
			double length = InputValidator.toDouble(lengthTextField.getText());
			double width = InputValidator.toDouble(widthTextField.getText());
			double height = InputValidator.toDouble(heightTextField.getText());
			double FB = InputValidator.toDouble(FBTextField.getText());
			List<Double> peneterations = InputValidator
					.toDoubleArray(peneterationsTextField.getText());
			List<Double> areas = InputValidator.toDoubleArray(areasTextField
					.getText());

			BuildData data = new BuildData();
			if (id != -1) {
				data.setId(id);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"ID is not valid", "Input validation failed",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (startPointId != -1) {
				data.setStartPointId(startPointId);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"Start Point ID is not valid",
						"Input validation failed", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (endPointId != -1) {
				data.setEndPointId(endPointId);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"End Point ID is not valid", "Input validation failed",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (startEarthElevation != -1) {
				data.setStartEarthElevation(startEarthElevation);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"Start Earth Elevation is not valid",
						"Input validation failed", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (endEarthElevation != -1) {
				data.setEndEarthElevation(endEarthElevation);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"End Earth Elevation is not valid",
						"Input validation failed", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (length != -1) {
				data.setLength(length);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"Length is not valid", "Input validation failed",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (width != -1) {
				data.setWidth(width);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"Width is not valid", "Input validation failed",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (height != -1) {
				data.setHeight(height);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"Height is not valid", "Input validation failed",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (FB != -1) {
				data.setFB(FB);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"FB is not valid", "Input validation failed",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (peneterations != null) {
				data.setPeneterations(peneterations);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"Peneterations is not valid",
						"Input validation failed", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (areas != null) {
				data.setAreas(areas);
			} else {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"Areas is not valid", "Input validation failed",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!ChannelController.getInstance().buildChannel(data)) {
				JOptionPane.showMessageDialog(BuildChannelDialog.this,
						"Build channel failed", "Build process failed",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				BuildChannelDialog.this.getOwner().repaint();
				BuildChannelDialog.this.dispose();
			}
		}
	}

	private class cancelHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BuildChannelDialog.this.dispose();
		}

	}
}
