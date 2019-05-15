import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AdminCinemas extends JPanel{
	TitledBorder tblBord;
	JButton btnAdd;
	static JTable table;
	static Cinema cin = new Cinema();
	AdminCinemaInfoPanel[] c;
	JScrollPane scroll;
	JPanel panel;
	static JFrame frame;
	static AdminCinemaInfoPanel add;
	public AdminCinemas() {
		tblBord = new TitledBorder("");
		setBorder(tblBord);
		table = cin.getTable();
		table.setModel(Cinema.mdl);
		int q = cin.getRecordCount();
		c = new AdminCinemaInfoPanel[q];
		btnAdd = new JButton("Add Cinema");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame = new JFrame("Add Cinema");
				frame.setVisible(true);
				frame.setSize(600, 600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setBackground(Color.PINK);
				frame.setResizable(false);
				JPanel pan = new JPanel();
				
				add = new AdminCinemaInfoPanel();
				frame.add(add).setBounds(50,50,500,500);
				
				
			}
		});
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 10+(q-1)*250));
		panel.setLayout(null);
		setLayout(null);
		for(int w =0;w<q-1;w++){
			c[w] = new AdminCinemaInfoPanel(w);
			panel.add(c[w]).setBounds(10,10+(w*250),960,250);
			
		}
		scroll = new JScrollPane(panel);
		scroll.setPreferredSize(new Dimension(1000,500));
		add(scroll).setBounds(100,20,1000,500);
		add(btnAdd).setBounds(200,530,200,50);
	}
	void updateCinemas(){
		panel.removeAll();
		int q = cin.getRecordCount();
		c = new AdminCinemaInfoPanel[q];
		panel.setPreferredSize(new Dimension(1000, 10+(q-1)*250));
		panel.setLayout(null);
		setLayout(null);
		for(int w =0;w<q-1;w++){
			c[w] = new AdminCinemaInfoPanel(w);
			panel.add(c[w]).setBounds(10,10+(w*250),960,250);
			
		}
	}
	
}
