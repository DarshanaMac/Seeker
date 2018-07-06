package com.genesislab.uis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.genesislab.corebase.DBConnector;

import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SeekerUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtCSVFilePath;
	private JTextField txtIDsToFetch;
	private JTextField txtFBID;
	public static URL checkedUrl;
	public String csvFilePath;
	
	static Connection connection = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			checkedUrl = SeekerUI.class.getResource("/checked.png");
			//connecting to database
			connection = DBConnector.dbConnector();
			if(connection.isValid(0))
				System.out.println("Database Connection Established");
			else
				System.out.println("Database Connection Failed");
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDevelopedByGenesislab = new JLabel("Developed by GenesisLab Inc.");
		lblDevelopedByGenesislab.setForeground(Color.LIGHT_GRAY);
		lblDevelopedByGenesislab.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		lblDevelopedByGenesislab.setBounds(180, 341, 147, 14);
		contentPane.add(lblDevelopedByGenesislab);
		
		JLabel lblDataFetcher = new JLabel("Data Fetcher");
		lblDataFetcher.setForeground(Color.WHITE);
		lblDataFetcher.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDataFetcher.setBounds(173, 13, 161, 40);
		contentPane.add(lblDataFetcher);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 72, 246, 278);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVisible(false);
		lblNewLabel.setIcon(new ImageIcon(checkedUrl));
		lblNewLabel.setIcon(new ImageIcon("E:\\GenesisLab\\Seeker\\Seeker\\resource\\checked.png"));
		lblNewLabel.setBounds(208, 42, 21, 30);
		panel.add(lblNewLabel);
		
		JLabel lblUploadCsvFile = new JLabel("Select CSV file containing FB IDs :");
		lblUploadCsvFile.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		lblUploadCsvFile.setForeground(Color.WHITE);
		lblUploadCsvFile.setBounds(12, 46, 213, 23);
		panel.add(lblUploadCsvFile);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter csvFileFilter = new FileNameExtensionFilter("CSV File", "csv");
				fileChooser.setFileFilter(csvFileFilter);
				fileChooser.setDialogTitle("Choose CSV containing FB IDs");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				if(fileChooser.showOpenDialog(btnSelect) == JFileChooser.APPROVE_OPTION)
				{
					File file = fileChooser.getSelectedFile();
					csvFilePath = file.getAbsolutePath();
					txtCSVFilePath.setText(csvFilePath);
					lblNewLabel.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "No CSV file selected", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnSelect.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		btnSelect.setBounds(151, 76, 78, 23);
		panel.add(btnSelect);
		
		JButton btnUpload = new JButton("Upload!");
		btnUpload.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		btnUpload.setBounds(81, 111, 84, 23);
		btnUpload.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.add(btnUpload);
		
		txtCSVFilePath = new JTextField();
		txtCSVFilePath.setEditable(false);
		txtCSVFilePath.setBounds(12, 76, 139, 23);
		txtCSVFilePath.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.add(txtCSVFilePath);
		txtCSVFilePath.setColumns(10);
		
		
		
		JLabel lblNumberOfFbIds = new JLabel("Number of FB IDs Inserted:");
		lblNumberOfFbIds.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		lblNumberOfFbIds.setForeground(Color.WHITE);
		lblNumberOfFbIds.setBounds(29, 225, 193, 14);
		panel.add(lblNumberOfFbIds);
		
		JLabel lblUploadedAmount = new JLabel("100");
		lblUploadedAmount.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		lblUploadedAmount.setForeground(Color.WHITE);
		lblUploadedAmount.setBounds(192, 225, 30, 14);
		panel.add(lblUploadedAmount);
		
		JLabel lblImportSuccessful = new JLabel("Import Successful!");
		lblImportSuccessful.setHorizontalAlignment(SwingConstants.LEFT);
		lblImportSuccessful.setIcon(new ImageIcon(checkedUrl));
		//lblImportSuccessful.setIcon(new ImageIcon("E:\\GenesisLab\\Seeker\\Seeker\\Resources\\checked.png"));
		lblImportSuccessful.setForeground(Color.WHITE);
		lblImportSuccessful.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		lblImportSuccessful.setBounds(53, 190, 139, 23);
		panel.add(lblImportSuccessful);
		
		JLabel lblFbIdUpload = new JLabel("FB ID Upload");
		lblFbIdUpload.setForeground(Color.WHITE);
		lblFbIdUpload.setFont(new Font("Ubuntu", Font.BOLD, 18));
		lblFbIdUpload.setBounds(16, 17, 117, 23);
		panel.add(lblFbIdUpload);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(252, 72, 246, 278);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNoOfIds = new JLabel("No of IDs to be fetched :");
		lblNoOfIds.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		lblNoOfIds.setForeground(Color.WHITE);
		lblNoOfIds.setBounds(18, 68, 145, 14);
		panel_1.add(lblNoOfIds);
		
		txtIDsToFetch = new JTextField();
		txtIDsToFetch.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDsToFetch.setBounds(162, 66, 62, 20);
		txtIDsToFetch.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(txtIDsToFetch);
		txtIDsToFetch.setColumns(10);
		
		JButton btnFetch = new JButton("Fetch");
		btnFetch.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		btnFetch.setBounds(42, 107, 65, 23);
		btnFetch.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(btnFetch);
		
		JButton btnViewReport = new JButton("View Report");
		btnViewReport.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		btnViewReport.setBounds(125, 107, 99, 23);
		btnViewReport.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(btnViewReport);
		
		JLabel lblEnterFbId = new JLabel("Enter FB ID :");
		lblEnterFbId.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		lblEnterFbId.setForeground(Color.WHITE);
		lblEnterFbId.setBounds(18, 207, 89, 14);
		panel_1.add(lblEnterFbId);
		
		txtFBID = new JTextField();
		txtFBID.setHorizontalAlignment(SwingConstants.CENTER);
		txtFBID.setBounds(94, 204, 134, 20);
		txtFBID.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(txtFBID);
		txtFBID.setColumns(10);
		
		JButton btnFetchSingle = new JButton("Fetch");
		btnFetchSingle.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		btnFetchSingle.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnFetchSingle.setBounds(129, 244, 99, 23);
		panel_1.add(btnFetchSingle);
		
		JLabel lblSingleFetch = new JLabel("Single Fetch");
		lblSingleFetch.setFont(new Font("Ubuntu", Font.BOLD, 18));
		lblSingleFetch.setForeground(Color.WHITE);
		lblSingleFetch.setBounds(18, 159, 117, 23);
		panel_1.add(lblSingleFetch);
		
		JLabel lblBulkFetch = new JLabel("Bulk Fetch");
		lblBulkFetch.setForeground(Color.WHITE);
		lblBulkFetch.setFont(new Font("Ubuntu", Font.BOLD, 18));
		lblBulkFetch.setBounds(18, 20, 117, 23);
		panel_1.add(lblBulkFetch);
		
		JLabel lblResetBulk = new JLabel("");
		lblResetBulk.setToolTipText("Reset Criterias");
		lblResetBulk.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				txtIDsToFetch.setText(null);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				txtIDsToFetch.setText(null);
			}
		});
		lblResetBulk.setIcon(new ImageIcon("E:\\GenesisLab\\Seeker\\Seeker\\resource\\synchronize.png"));
		lblResetBulk.setBounds(194, 11, 42, 46);
		panel_1.add(lblResetBulk);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Reset Criterias");
		lblNewLabel_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				txtFBID.setText(null);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("E:\\GenesisLab\\Seeker\\Seeker\\resource\\synchronize.png"));
		lblNewLabel_1.setBounds(190, 154, 46, 39);
		panel_1.add(lblNewLabel_1);
	}
}
