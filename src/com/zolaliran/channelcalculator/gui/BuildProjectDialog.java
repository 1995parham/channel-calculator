package com.zolaliran.channelcalculator.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.zolaliran.channelcalculator.controllers.ProjectController;
import com.zolaliran.channelcalculator.validator.InputValidator;

public class BuildProjectDialog extends JDialog {

	private static final long serialVersionUID = -988584482814234670L;

	private JPanel contentPane;
	private JButton loadProjectButton;
	private JButton newProjectButton;
	private JLabel pathLabel;
	private JTextField pathTextField;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel VmaxLabel;
	private JTextField VmaxTextField;
	private JLabel VminLabel;
	private JTextField VminTextField;
	private JLabel rainfallIntensityLabel;
	private JTextField rainfallIntensityTextField;
	private JLabel manningCoefficientLabel;
	private JTextField manningCoefficientTextField;
	private JButton selectPathButton;
	private JButton exitButton;

	private String path;

	public BuildProjectDialog(JFrame owner) {
		super(owner, "Build Project");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(400, 500));
		setLocationRelativeTo(owner);
		setModal(true);
		contentPane = new JPanel();
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		setContentPane(contentPane);

		nameLabel = new JLabel("Project Name :");
		sl_contentPane.putConstraint(SpringLayout.WEST, nameLabel, 10,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, nameLabel, 10,
				SpringLayout.NORTH, contentPane);
		contentPane.add(nameLabel);

		nameTextField = new JTextField(25);
		nameTextField.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.WEST, nameTextField, 5,
				SpringLayout.EAST, nameLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, nameTextField, 0,
				SpringLayout.NORTH, nameLabel);
		contentPane.add(nameTextField);

		pathLabel = new JLabel("Project Path :");
		sl_contentPane.putConstraint(SpringLayout.WEST, pathLabel, 0,
				SpringLayout.WEST, nameLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, pathLabel, 0,
				SpringLayout.EAST, nameLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, pathLabel, 10,
				SpringLayout.SOUTH, nameLabel);
		contentPane.add(pathLabel);

		pathTextField = new JTextField(25);
		pathTextField.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.WEST, pathTextField, 0,
				SpringLayout.WEST, nameTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, pathTextField, 0,
				SpringLayout.EAST, nameTextField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, pathTextField, 0,
				SpringLayout.NORTH, pathLabel);
		contentPane.add(pathTextField);

		VmaxLabel = new JLabel("Project Vmax :");
		sl_contentPane.putConstraint(SpringLayout.WEST, VmaxLabel, 0,
				SpringLayout.WEST, pathLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, VmaxLabel, 0,
				SpringLayout.EAST, pathLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, VmaxLabel, 10,
				SpringLayout.SOUTH, pathLabel);
		contentPane.add(VmaxLabel);

		VmaxTextField = new JTextField(25);
		VmaxTextField.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.WEST, VmaxTextField, 0,
				SpringLayout.WEST, pathTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, VmaxTextField, 0,
				SpringLayout.EAST, pathTextField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, VmaxTextField, 0,
				SpringLayout.NORTH, VmaxLabel);
		contentPane.add(VmaxTextField);

		VminLabel = new JLabel("Project Vmin :");
		sl_contentPane.putConstraint(SpringLayout.WEST, VminLabel, 0,
				SpringLayout.WEST, VmaxLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, VminLabel, 0,
				SpringLayout.EAST, VmaxLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, VminLabel, 10,
				SpringLayout.SOUTH, VmaxLabel);
		contentPane.add(VminLabel);

		VminTextField = new JTextField(25);
		VminTextField.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.WEST, VminTextField, 0,
				SpringLayout.WEST, VmaxTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, VminTextField, 0,
				SpringLayout.EAST, VmaxTextField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, VminTextField, 0,
				SpringLayout.NORTH, VminLabel);
		contentPane.add(VminTextField);

		rainfallIntensityLabel = new JLabel("Project Rainfall :");
		sl_contentPane.putConstraint(SpringLayout.WEST, rainfallIntensityLabel,
				0, SpringLayout.WEST, VminLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, rainfallIntensityLabel,
				0, SpringLayout.EAST, VminLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH,
				rainfallIntensityLabel, 10, SpringLayout.SOUTH, VminLabel);
		contentPane.add(rainfallIntensityLabel);

		rainfallIntensityTextField = new JTextField(25);
		rainfallIntensityTextField.setEditable(false);
		sl_contentPane
				.putConstraint(SpringLayout.WEST, rainfallIntensityTextField,
						0, SpringLayout.WEST, VminTextField);
		sl_contentPane
				.putConstraint(SpringLayout.EAST, rainfallIntensityTextField,
						0, SpringLayout.EAST, VminTextField);
		sl_contentPane.putConstraint(SpringLayout.NORTH,
				rainfallIntensityTextField, 0, SpringLayout.NORTH,
				rainfallIntensityLabel);
		contentPane.add(rainfallIntensityTextField);

		manningCoefficientLabel = new JLabel("Project Manning :");
		sl_contentPane.putConstraint(SpringLayout.WEST,
				manningCoefficientLabel, 0, SpringLayout.WEST,
				rainfallIntensityLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST,
				manningCoefficientLabel, 0, SpringLayout.EAST,
				rainfallIntensityLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH,
				manningCoefficientLabel, 10, SpringLayout.SOUTH,
				rainfallIntensityLabel);
		contentPane.add(manningCoefficientLabel);

		manningCoefficientTextField = new JTextField(25);
		manningCoefficientTextField.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.WEST,
				manningCoefficientTextField, 0, SpringLayout.WEST,
				rainfallIntensityTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST,
				manningCoefficientTextField, 0, SpringLayout.EAST,
				rainfallIntensityTextField);
		sl_contentPane.putConstraint(SpringLayout.NORTH,
				manningCoefficientTextField, 0, SpringLayout.NORTH,
				manningCoefficientLabel);
		contentPane.add(manningCoefficientTextField);

		selectPathButton = new JButton("Select Path");
		sl_contentPane.putConstraint(SpringLayout.WEST, selectPathButton, 120,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, selectPathButton, 10,
				SpringLayout.SOUTH, manningCoefficientLabel);
		contentPane.add(selectPathButton);
		selectPathButton.addActionListener(new selectPathHandler());

		exitButton = new JButton("Exit");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, exitButton, -10,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, exitButton, 30,
				SpringLayout.WEST, contentPane);
		exitButton.addActionListener(new ExitHandler());
		contentPane.add(exitButton);

		newProjectButton = new JButton("New Project");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, newProjectButton, -10,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, newProjectButton, 20,
				SpringLayout.EAST, exitButton);
		contentPane.add(newProjectButton);
		newProjectButton.addActionListener(new newProjectHandler());
		newProjectButton.setEnabled(false);

		loadProjectButton = new JButton("Load Project");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, loadProjectButton,
				-10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, loadProjectButton, 20,
				SpringLayout.EAST, newProjectButton);
		contentPane.add(loadProjectButton);
		loadProjectButton.addActionListener(new loadProjectHandler());
		loadProjectButton.setEnabled(false);
	}

	private void loadingFile(File file) {
		pathTextField.setText(file.getPath());
		path = file.getPath();
		if (file.isDirectory()) {
			nameTextField.setEditable(true);
			newProjectButton.setEnabled(true);
			VmaxTextField.setEditable(true);
			VminTextField.setEditable(true);
			rainfallIntensityTextField.setEditable(true);
			manningCoefficientTextField.setEditable(true);
			loadProjectButton.setEnabled(false);
		} else if (file.getName().endsWith(".pro")) {
			nameTextField.setText(file.getName().split("[.]")[0]);
			nameTextField.setEditable(false);
			newProjectButton.setEnabled(false);
			VmaxTextField.setEditable(false);
			VminTextField.setEditable(false);
			rainfallIntensityTextField.setEditable(false);
			manningCoefficientTextField.setEditable(false);
			loadProjectButton.setEnabled(true);
		} else {
			return;
		}
	}

	private class selectPathHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.showDialog(BuildProjectDialog.this, "Select");
			File file = chooser.getSelectedFile();
			if (file != null) {
				loadingFile(file);
			}
		}
	}

	private class newProjectHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String projectName = InputValidator.validate(nameTextField
					.getText());
			if (projectName.length() == 0) {
				JOptionPane.showMessageDialog(BuildProjectDialog.this,
						"Project name is empty", "Project Name",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			double Vmax = InputValidator.toDouble(VmaxTextField.getText());
			if (Vmax == -1) {
				JOptionPane.showMessageDialog(BuildProjectDialog.this,
						"Vmax is empty", "Project Vmax",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			ProjectController.getInstance().setVmax(Vmax);
			double Vmin = InputValidator.toDouble(VminTextField.getText());
			if (Vmin == -1) {
				JOptionPane.showMessageDialog(BuildProjectDialog.this,
						"Vmin is empty", "Project Vmin",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			ProjectController.getInstance().setVmin(Vmin);
			double rainfallIntensity = InputValidator
					.toDouble(rainfallIntensityTextField.getText());
			if (rainfallIntensity == -1) {
				JOptionPane.showMessageDialog(BuildProjectDialog.this,
						"Rainfall is empty", "Project Rainfall",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			ProjectController.getInstance().setRainfallIntensity(
					rainfallIntensity);
			double manningCoefficient = InputValidator
					.toDouble(manningCoefficientTextField.getText());
			if (manningCoefficient == -1) {
				JOptionPane.showMessageDialog(BuildProjectDialog.this,
						"Manning is empty", "Project Manning",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			ProjectController.getInstance().setManningCoefficient(
					manningCoefficient);
			ProjectController.getInstance().setPath(
					path + File.separator + projectName + ".pro");
			BuildProjectDialog.this.dispose();
		}
	}

	private class loadProjectHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			ProjectController.getInstance().setPath(path);
			if (ProjectController.getInstance().load()) {
				BuildProjectDialog.this.dispose();
			} else {
				JOptionPane.showMessageDialog(BuildProjectDialog.this,
						"Load Failed...We are sorry !!! see log for details",
						"Load", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}

	private class ExitHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}

}
