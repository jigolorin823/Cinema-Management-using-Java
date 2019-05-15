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

public class Cinema {
	FileReader fr;
	FileWriter fw;
	Scanner scan;
	StringTokenizer str;
	static DefaultTableModel mdl;
	JTable table;
	TableRowSorter sort;
	Vector row;
	
	
	Cinema(){
		String[] col={"Cinema Number","Movie ID","Price","Number of Seats","Status"};
		mdl = new DefaultTableModel();
		mdl.setColumnIdentifiers(col);
		
		
		try {
			fr=new FileReader("Cinemas.txt");
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
	JTable getTable(){
		return table;
	}
	void updateTable(){
		table.removeAll();
		String[] col={"Cinema Number","Movie ID","Price","Number of Seats","Status"};
		mdl = new DefaultTableModel();
		mdl.setColumnIdentifiers(col);
		
		
		try {
			fr=new FileReader("Cinemas.txt");
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
	int getRecordCount(){
		int count=1;
		try {
			fr=new FileReader("Cinemas.txt");
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
	void search(String search){
		table.setRowSorter(sort);
		sort.setRowFilter(RowFilter.regexFilter(search, 0,1,2,3,4));
	}
	void addCinema(String record){
		try {
			fw=new FileWriter("Cinemas.txt",true);
			fw.write(record);
			fw.close();		
		} catch (Exception e) {
			System.err.println("Error addCinema: "+e.getMessage());
		}
	} 
	void updateCinemas(JTable table){
		try {
			fw=new FileWriter("Cinemas.txt");
			for(int q=0;q<table.getRowCount();q++){
				for(int w=0;w<table.getColumnCount();w++){
					fw.write(table.getValueAt(q, w)+"|");
				}fw.write("\n");
			}
			fw.close();		
		} catch (Exception e) {
			System.err.println("Error updateCinemas: "+e.getMessage());
		}
	}
	
	
}
