import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AdminMovies extends JPanel{
	TitledBorder tblBord;
	JButton qwe;
	static JTable table;
	JLabel lblSearch;
	JTextField txtSearch;
	JPanel tablePanel,panel;
	JButton btnAdd;
	int row;
	static Movies mov = new Movies();
	AdminMoviePanel[] m;
	JScrollPane scroll;
	public AdminMovies() {
		tblBord = new TitledBorder("");
		setBorder(tblBord);
		
		btnAdd = new JButton("Add Movie");
		
		table = mov.getTable();
		table.setModel(Movies.mdl);
		
		int q = mov.getRecordCount();
		m = new AdminMoviePanel[q];
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 10+(q-1)*350));
		panel.setLayout(null);
		setLayout(null);
		for(int w =0;w<q-1;w++){
			m[w] = new AdminMoviePanel(w);
			panel.add(m[w]).setBounds(10,10+(w*350),960,350);
			
		}
		scroll = new JScrollPane(panel);
		scroll.setPreferredSize(new Dimension(1000,500));
		add(scroll).setBounds(100,20,1000,500);
		add(btnAdd).setBounds(200,530,200,50);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddMovieFrame();
				
			}
		});
		
	}
	void updateMovies(){
		panel.removeAll();
		int q = mov.getRecordCount();
		panel.setPreferredSize(new Dimension(1000, 10+(q-1)*350));
		panel.setLayout(null);
		m = new AdminMoviePanel[q];
		for(int w =0;w<q-1;w++){
			m[w] = new AdminMoviePanel(w);
			panel.add(m[w]).setBounds(10,10+(w*350),960,350);
			
		}
//		scroll = new JScrollPane(panel);
//		scroll.setPreferredSize(new Dimension(1000,500));
	}
}
