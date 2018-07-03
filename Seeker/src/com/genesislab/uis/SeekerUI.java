package com.genesislab.uis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

public class SeekerUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeekerUI frame = new SeekerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeekerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataFetcher = new JLabel("Data Fetcher");
		lblDataFetcher.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDataFetcher.setBounds(173, 21, 161, 40);
		contentPane.add(lblDataFetcher);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 72, 246, 278);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUploadCsvFile = new JLabel("Select CSV file containing FB IDs :");
		lblUploadCsvFile.setBounds(10, 21, 170, 23);
		panel.add(lblUploadCsvFile);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.setBounds(158, 54, 65, 23);
		panel.add(btnUpload);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(94, 88, 65, 23);
		panel.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(20, 55, 139, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumberOfFb = new JLabel("Number of FB IDs Inserted:");
		lblNumberOfFb.setBounds(20, 161, 139, 14);
		panel.add(lblNumberOfFb);
		
		JLabel label = new JLabel("100");
		label.setBounds(158, 161, 46, 14);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(252, 72, 246, 278);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNoOfIds = new JLabel("No of IDs to be fetched :");
		lblNoOfIds.setBounds(10, 22, 128, 14);
		panel_1.add(lblNoOfIds);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 19, 65, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnFetch = new JButton("Fetch");
		btnFetch.setBounds(42, 61, 65, 23);
		panel_1.add(btnFetch);
		
		JButton btnViewReport = new JButton("View Report");
		btnViewReport.setBounds(125, 61, 99, 23);
		panel_1.add(btnViewReport);
		
		JLabel lblEnterFbId = new JLabel("Enter FB ID :");
		lblEnterFbId.setBounds(42, 128, 65, 14);
		panel_1.add(lblEnterFbId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(113, 125, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("Fetch");
		button.setBounds(134, 156, 65, 23);
		panel_1.add(button);
	}
}
