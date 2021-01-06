package com.zolaliran.channelcalculator.gui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.zolaliran.channelcalculator.controllers.ChannelController;
import com.zolaliran.channelcalculator.domain.Channel;

public class EditChannelDialog extends JDialog {

	private static final long serialVersionUID = -8184303982039792932L;

	private Channel channel;
	private JPanel contentPane;
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel startPointIdLabel;
	private JTextField startPointIdTextField;
	private JLabel endPointIdLabel;
	private JTextField endPointIdTextField;
	private JLabel lengthLabel;
	private JTextField lengthTextField;
	private JLabel widthLabel;
	private JTextField widthTextField;
	private JLabel FBLabel;
	private JTextField FBTextField;
	private JLabel heightLabel;
	private JTextField heightTextField;
	private JLabel peneterationsLabel;
	private JTextField peneterationsTextField;
	private JLabel areasLabel;
	private JTextField areasTextField;

	public EditChannelDialog(int index, Container owner) {
		setSize(new Dimension(400, 500));
		setLocationRelativeTo(owner);
		setModal(true);
		contentPane = new JPanel();
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		setContentPane(contentPane);

		channel = ChannelController.getInstance().getChannel(index);

		idLabel = new JLabel("ID:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, idLabel, 20,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, idLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(idLabel);

		idTextField = new JTextField(20);
		idTextField.setText(Integer.toString(channel.getId()));
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
		startPointIdTextField.setText(Integer.toString(channel
				.getStartPointId()));
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
		endPointIdTextField.setText(Integer.toString(channel.getEndPointId()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, endPointIdTextField,
				20, SpringLayout.NORTH, startPointIdTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, endPointIdTextField,
				-10, SpringLayout.EAST, contentPane);
		contentPane.add(endPointIdTextField);

		lengthLabel = new JLabel("Length:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lengthLabel, 20,
				SpringLayout.NORTH, endPointIdLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lengthLabel, 10,
				SpringLayout.WEST, contentPane);
		contentPane.add(lengthLabel);

		lengthTextField = new JTextField(20);
		lengthTextField.setText(Double.toString(channel.getLength()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lengthTextField, 20,
				SpringLayout.NORTH, endPointIdTextField);
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
		widthTextField.setText(Double.toString(channel.getWidth()));
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
		FBTextField.setText(Double.toString(channel.getFB()));
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
		heightTextField.setText(Double.toString(channel.getHeight()));
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
}
