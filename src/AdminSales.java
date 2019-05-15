import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.html.parser.DTD;

public class AdminSales extends JPanel{
	TitledBorder tblBord;
	JButton btnDaily,btnCin;
	FileReader fr;
	FileWriter fw;
	Scanner scan;
	StringTokenizer str;
	DefaultTableModel mdl,mdl2;
	JTable table,table2;
	TableRowSorter sort;
	JPanel tablePanel,tablePanel2;
	JScrollPane scroll;
	JLabel lblMovies,lblSearch,lblDSales;
	JTextField txtSearch,txtDSales;
	JTextArea txt;
	Vector row,row2;
	DateTime dt;
	String[] col = {"Title", "Total Sales"};
	String[] col2 = {"Date", "Daily Sales"};
	public AdminSales() {
		dt = new DateTime("date");
		table = new JTable();
		tblBord = new TitledBorder("");
		setBorder(tblBord);
		tablePanel = new JPanel();
		tablePanel2 = new JPanel();
		mdl = new DefaultTableModel();
		mdl.setColumnIdentifiers(col);
		int q = AdminMovies.mov.getRecordCount()-1;
		for(int w =0;w<q;w++){
			row = new Vector();
			int movID = Integer.parseInt(AdminMovies.table.getValueAt(w, 0).toString());
			row.add(AdminMovies.table.getValueAt(movID-1, 1));
			row.add(totalSales(movID));
//			row.add(getCinNum(movID-1));
			mdl.addRow(row);
			
		}
		table = new JTable(mdl);
		sort = new TableRowSorter(mdl);
		
		table2 = new JTable();
		mdl2 = new DefaultTableModel();
		mdl2.setColumnIdentifiers(col2);
		table2.setModel(mdl2);
		scroll = new JScrollPane(table2);
		
		
		table.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				if(e.getSource().equals(table)){
					
					tablePanel2.removeAll();
					mdl2 = new DefaultTableModel();
					mdl2.setColumnIdentifiers(col2);
					int c = table.getSelectedRow();
					
					for(int q=0;q<AdminReservations.table.getRowCount();q++){
						row2 = new Vector();
						if(AdminReservations.table.getValueAt(q, 9).toString().equals("Active")){
							if(Integer.parseInt(AdminReservations.table.getValueAt(q, 4).toString())==(c+1)){
								String date = AdminReservations.table.getValueAt(q, 8).toString();
								row2.add(date);
								row2.add(dailySales(date,(c+1))+"");
//								JOptionPane.showMessageDialog(null, dailySales(date));
								mdl2.addRow(row2);
							}
						}
						
						
					}
					table2.setModel(mdl2);
					tablePanel2.add(scroll, BorderLayout.CENTER);
				}				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		lblSearch = new JLabel("Search ");
		txtSearch = new JTextField();
		
		
		
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		setLayout(null);
		tablePanel2.setLayout(new BorderLayout());
		tablePanel2.add(scroll, BorderLayout.CENTER);
		add(lblSearch).setBounds(10,10,50,30);
		add(txtSearch).setBounds(70,10,120,30);
		add(tablePanel).setBounds(10,50,400,400);
		add(tablePanel2).setBounds(500,50,500,500);
//		add(btnCancel).setBounds(900,50,150,50);

		
	}
	
	int getCinNum(int movID){
		int num=0;
		int w =0;
		boolean found = false;
		while(found==false&&w<AdminReservations.table.getRowCount()){
			int a =Integer.parseInt(AdminReservations.table.getValueAt(w, 4).toString());
			if(a==movID){
				num=a;
				found = true;
			}
			w++;
		}
		num++;
		return num;
	}
	double totalSales(int movID){
		double total = 0.00;
		double sal = 0.00;
		for(int i = 0; i < AdminReservations.table.getRowCount(); i++){
			if(AdminReservations.table.getValueAt(i, 9).toString().equals("Active")){
				if(Integer.parseInt(AdminReservations.table.getValueAt(i, 4).toString())==movID){
			        sal = Double.parseDouble(AdminReservations.table.getValueAt(i, 7).toString());
			        total+=sal;
				}
			}			
	    }
//		JOptionPane.showMessageDialog(null, total);
		return total;
	}
	double dailySales(String date, int movID){
		double total = 0.00;
		double amount=0.0;
		for(int i = 0; i < AdminReservations.table.getRowCount(); i++){
			if(AdminReservations.table.getValueAt(i, 9).toString().equals("Active")){
				if(Integer.parseInt(AdminReservations.table.getValueAt(i, 4).toString())==movID){
					if(AdminReservations.table.getValueAt(i, 8).toString().equals(date)){
						
				        amount=Double.parseDouble(AdminReservations.table.getValueAt(i, 7)+"");
				        total+=amount;
					}
				}
				
			}			
	    }
		return total;
	}
	String dailyCinemaSales(){
		String hold="Daily Cinema Sales\n";
		int q = AdminCinemas.cin.getRecordCount()-1;
		for(int w=0;w<q;w++){
			double total = 0.00;
			double amount=0.0;
			for(int i = 0; i < AdminReservations.table.getRowCount(); i++){
				if(AdminReservations.table.getValueAt(i, 8).toString().equals("Active")){
					if(Integer.parseInt(AdminReservations.table.getValueAt(i, 3).toString())==(w+1)){
						if(AdminReservations.table.getValueAt(i, 7).toString().equals(dt.getText())){
					        amount=Double.parseDouble(AdminReservations.table.getValueAt(i, 6)+"");
					        total+=amount;
						}
					}
					
				}			
		    }
			hold+="\n\tCinema"+(w+1)+": Php "+total;
		}
		
		
		return hold;
	}
}
