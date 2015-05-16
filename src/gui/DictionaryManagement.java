package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.AbstractAction;
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

import logic.AddWord;
import logic.LoadDictionary;
import logic.PopulateDictionary;
import logic.RemoveWord;
import logic.SaveDictionary;
import logic.SearchWord;
import logic.WordMatcher;
import model.Dictionary;

public class DictionaryManagement {

	private JFrame frame;
	private JPanel DescriptionPanel;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane DescriptionPane;
	private String[] operations = {"Add Word", "Remove Word", "Search Word", "Populate Dictionary", "Save Dictionary", "Load Dictionary", "Show Dictionary"};
	private String[] columns = {"word", "description"};
	private JTable table;
	private JComboBox comboBox;
	private Dictionary dic;

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
		dic = new Dictionary();
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
		table.setEnabled(false);
		frame.getContentPane().add(lblOperation);
		//table.setModel(m);
		table.setVisible(false);
		comboBox = new JComboBox();
		for(int i = 0; i<operations.length; i++)
			comboBox.addItem(operations[i]);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setBounds(50, 78, 650, 188);
		frame.getContentPane().add(scrollPane);
		comboBox.setBounds(180, 418, 132, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.setBounds(365, 490, 89, 23);
		btnExecute.addActionListener(new ExecuteAction());
		frame.getContentPane().add(btnExecute);
	}
	
	private class ExecuteAction extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int option = comboBox.getSelectedIndex();
			int maxWidthColumn1;
			int maxWidthColumn2;
			switch(option)
			{
			case 0 :
				AddWord a = new AddWord(dic);
				a.Operation(textField.getText(), textArea.getText());
				break;
			case 1 :
				RemoveWord r = new RemoveWord(dic);
				r.Operation(textField.getText(), "");
				break;
			case 2 :
				WordMatcher w = new WordMatcher(dic);
				TreeMap<String,String> temp = w.Operation(textField.getText(), "");
				Object data[][] = new Object[temp.size()][2];
				int n = 0;
				maxWidthColumn1 = Integer.MIN_VALUE;
				maxWidthColumn2 = Integer.MIN_VALUE;
				for(Entry<String, String> e : temp.entrySet())
				{
					data[n][0] = e.getKey().toString();
					data[n][1] = e.getValue().toString();
					if(e.getKey().toString().length()>maxWidthColumn1)
						maxWidthColumn1 = e.getKey().toString().length();
					if(e.getValue().toString().length()>maxWidthColumn2)
						maxWidthColumn2 = e.getValue().toString().length();
					n++;
				}
				DefaultTableModel m = new DefaultTableModel(data, columns);
				table.setModel(m);
				if(maxWidthColumn1>table.getColumnModel().getColumn(0).getMinWidth())
					table.getColumnModel().getColumn(0).setPreferredWidth(maxWidthColumn1+250);
				if(maxWidthColumn2>table.getColumnModel().getColumn(1).getMinWidth())
					table.getColumnModel().getColumn(1).setPreferredWidth(maxWidthColumn2+1000);
				table.setVisible(true);
				break;
			case 3 :
				PopulateDictionary p = new PopulateDictionary(dic);
				p.Operation("", "");
				break;
			case 4 :
				SaveDictionary save = new SaveDictionary(dic);
				save.Operation("", "");
				break;
			case 5 :
				LoadDictionary load = new LoadDictionary(dic);
				load.Operation("", "");
				break;
			case 6 :
				temp = dic.getDic();
				Object data2[][] = new Object[temp.size()][2];
				n = 0;
				maxWidthColumn1 = Integer.MIN_VALUE;
				maxWidthColumn2 = Integer.MIN_VALUE;
				for(Entry<String, String> it : temp.entrySet())
				{
					data2[n][0] = it.getKey().toString();
					data2[n][1] = it.getValue().toString();
					if(it.getKey().toString().length()>maxWidthColumn1)
						maxWidthColumn1 = it.getValue().toString().length();
					if(it.getValue().toString().length()>maxWidthColumn2)
						maxWidthColumn2 = it.getValue().toString().length();
					n++;
				}
				DefaultTableModel model = new DefaultTableModel(data2, columns);
				table.setModel(model);
				if(maxWidthColumn1>table.getColumnModel().getColumn(0).getMinWidth())
					table.getColumnModel().getColumn(0).setPreferredWidth(maxWidthColumn1);
				if(maxWidthColumn2>table.getColumnModel().getColumn(1).getMinWidth())
					table.getColumnModel().getColumn(1).setPreferredWidth(maxWidthColumn2);
				table.setVisible(true);
				break;
			}
		}
		
	}
}
