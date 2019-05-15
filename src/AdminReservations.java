import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AdminReservations extends JPanel{
	TitledBorder tblBord;
	JButton btnCancel;
	FileReader fr;
	FileWriter fw;
	Scanner scan;
	StringTokenizer str;
	DefaultTableModel mdl;
	static JTable table;
	TableRowSorter sort;
	JPanel tablePanel;
	JLabel lblSearch;
	JTextField txtSearch;
	Vector row;
	DateTime dt;
	static Tickets tic = new Tickets();
	public AdminReservations() {
		dt = new DateTime("date");
		table = AdminReservations.tic.getTable();
		table.setModel(AdminReservations.tic.mdl);
		tblBord = new TitledBorder("");
		setBorder(tblBord);
		tablePanel = new JPanel();
		
		lblSearch = new JLabel("Search ");
		lblSearch = new JLabel("Search ");
		txtSearch = new JTextField();
		
		btnCancel = new JButton("Cancel Reservation");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row==-1){
					JOptionPane.showMessageDialog(null, "Please select row to cancel");
				}else{
					int ch = JOptionPane.showConfirmDialog(null, "Cancel Reservation?", "Reservation", JOptionPane.YES_NO_OPTION);
					if(ch==JOptionPane.YES_OPTION){
						table.setValueAt("Cancelled", row, 9);
						tic.updateTickets(table);
					}
				}
				
			}
		});
		
		txtSearch.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
				if(e.getSource().equals(txtSearch)){
					String search=txtSearch.getText();
					tic.search(search);		
				}
			}
			public void keyPressed(KeyEvent e) {
			}
		});
		
		
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		setLayout(null);
		add(lblSearch).setBounds(10,10,50,30);
		add(txtSearch).setBounds(70,10,120,30);
		add(tablePanel).setBounds(10,50,800,500);
		add(btnCancel).setBounds(900,50,150,50);
		
	}
	void updateTable(){
		tablePanel.removeAll();
		table = AdminReservations.tic.getTable();
		table.setModel(AdminReservations.tic.mdl);
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
	}
}
