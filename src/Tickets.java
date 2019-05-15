import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Tickets {
	FileReader fr;
	FileWriter fw;
	Scanner scan;
	StringTokenizer str;
	static DefaultTableModel mdl;
	JTable table;
	TableRowSorter sort;
	Vector row;
	Tickets() {
		String[] col={"Sales ID","Qty","Type","Cinema Number","Movie ID","Time","Reservations","Sales","Date","Status"};
		mdl = new DefaultTableModel();
		mdl.setColumnIdentifiers(col);
		
		
		try {
			fr=new FileReader("TicketSales.txt");
			scan=new Scanner(fr);
			
			while(scan.hasNext()){
				
				str = new StringTokenizer(scan.nextLine(), "|");
				while(str.hasMoreTokens()){
					row=new Vector();
					for (int i = 0; i < col.length; i++) {
						row.add(str.nextToken());
					}
					mdl.addRow(row);
				}
				
			}
			
			scan.close();
		} catch (Exception e) {
			System.err.println("Error SetColumns: "+e.getMessage());
		}
		table = new JTable(mdl);
		sort = new TableRowSorter(mdl);
		
		
	
	}
	void updateTable(){
		String[] col={"Sales ID","Qty","Type","Cinema Number","Movie ID","Time","Reservations","Sales","Date","Status"};
		mdl = new DefaultTableModel();
		mdl.setColumnIdentifiers(col);
		
		
		try {
			fr=new FileReader("TicketSales.txt");
			scan=new Scanner(fr);
			
			while(scan.hasNext()){
				
				str = new StringTokenizer(scan.nextLine(), "|");
				while(str.hasMoreTokens()){
					row=new Vector();
					for (int i = 0; i < col.length; i++) {
						row.add(str.nextToken());
					}
					mdl.addRow(row);
				}
				
			}
			
			scan.close();
		} catch (Exception e) {
			System.err.println("Error SetColumns: "+e.getMessage());
		}
		table = new JTable(mdl);
		sort = new TableRowSorter(mdl);
	}
	void addRecord(String record){
		try {
			fw=new FileWriter("TicketSales.txt",true);
			fw.write(record);
			fw.close();		
		} catch (Exception e) {
			System.err.println("Error SetAdd: "+e.getMessage());
		}
	}
	void search(String search){
		table.setRowSorter(sort);
		sort.setRowFilter(RowFilter.regexFilter(search, 0,1,2,3,4,5,6,7,8,9));
	}
	JTable getTable(){
		return table;
	}
	int getRecordCount(){
		int count=1;
		try {
			fr=new FileReader("TicketSales.txt");
			scan=new Scanner(fr);
			while(scan.hasNext()){
				scan.nextLine();
				count++;
			}
		} catch (Exception e) {
			System.err.println("Error getRecordCount: "+e.getMessage());
		}
		return count;
	}
	void updateTickets(JTable table){
		try {
			fw=new FileWriter("TicketSales.txt");
			for(int q=0;q<table.getRowCount();q++){
				for(int w=0;w<table.getColumnCount();w++){
					fw.write(table.getValueAt(q, w)+"|");
				}fw.write("\n");
			}
			fw.close();			
		} catch (Exception e) {
			System.err.println("Error SetAdd: "+e.getMessage());
		}
	}
	Vector getReservations(String time, int cinemaNum,String date){
		int q = table.getRowCount();
		int w =0;
		Vector rsv = new Vector();
		while(w<q){
			if(table.getValueAt(w, 7).toString().equals(date)){
				if(table.getValueAt(w, 9).toString().equals("Active")){
					if(Integer.parseInt(table.getValueAt(w, 3).toString())==cinemaNum){
						if(table.getValueAt(w, 5).toString().equals(time)){
//							JOptionPane.showMessageDialog(null, table.getValueAt(w, 5).toString());
							StringTokenizer str = new StringTokenizer(table.getValueAt(w, 6).toString(),",");
							while(str.hasMoreTokens()){
								rsv.add(str.nextToken());
							}
						}
					}
				}
			}
			
			w++;
		}
		return rsv;
		
	}
}
