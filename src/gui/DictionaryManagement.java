package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class DictionaryManagement {

	private JFrame frame;
	private JPanel DescriptionPanel;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane DescriptionPane;
	private String[] operations = {"Add Word", "Remove Word", "Search Word", "Populate Dictionary", "Save Dictionary", "Load Dictionary", "Copy Dictionary"};
	private String[] columns = {"word", "description"};
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DictionaryManagement window = new DictionaryManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DictionaryManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDictionaryManagement = new JLabel("Dictionary Management");
		lblDictionaryManagement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDictionaryManagement.setBounds(314, 30, 195, 20);
		frame.getContentPane().add(lblDictionaryManagement);
		
		JLabel lblWord = new JLabel("Word : ");
		lblWord.setBounds(124, 349, 46, 14);
		frame.getContentPane().add(lblWord);
		
		textField = new JTextField();
		textField.setBounds(180, 346, 132, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblExplanation = new JLabel("Explanation : ");
		lblExplanation.setBounds(398, 349, 89, 14);
		frame.getContentPane().add(lblExplanation);
		
		DescriptionPanel = new JPanel();
		DescriptionPanel.setBounds(514, 349, 211, 150);
		frame.getContentPane().add(DescriptionPanel);
		textArea = new JTextArea(9,10);
		DescriptionPane = new JScrollPane(textArea);
		DescriptionPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		DescriptionPanel.add(DescriptionPane);
		
		table=new JTable();
		JLabel lblOperation = new JLabel("Operation : ");
		lblOperation.setBounds(100, 421, 72, 14);
		frame.getContentPane().add(lblOperation);
		Object data[][] = new Object[0][0];
		DefaultTableModel m = new DefaultTableModel(data, columns);
		table.setModel(m);
		JComboBox comboBox = new JComboBox();
		for(int i = 0; i<operations.length; i++)
			comboBox.addItem(operations[i]);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(144, 78, 496, 188);
		scrollPane.setViewportView(table);
		frame.getContentPane().add(scrollPane);
		comboBox.setBounds(180, 418, 132, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.setBounds(365, 490, 89, 23);
		frame.getContentPane().add(btnExecute);
	}
}
