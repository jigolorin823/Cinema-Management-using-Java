import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Movies {
	FileReader fr;
	FileWriter fw;
	Scanner scan;
	StringTokenizer str;
	static DefaultTableModel mdl;
	JTable table;
	TableRowSorter sort;
	Vector row;
	Movies() {
		String[] col={"Movie ID","Title","Synopsis","Rating","Duration","Genre","Poster"};
		mdl = new DefaultTableModel();
		mdl.setColumnIdentifiers(col);
		
		
		try {
			fr=new FileReader("Movies.txt");
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
			fr=new FileReader("Movies.txt");
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
	JTable getTable(){
		return table;
	}
	void updateTable(){
		table.removeAll();
		String[] col={"Movie ID","Title","Synopsis","Rating","Duration","Genre","Poster",};
		mdl = new DefaultTableModel();
		mdl.setColumnIdentifiers(col);
		
		
		try {
			fr=new FileReader("Movies.txt");
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
	void search(String search){
		table.setRowSorter(sort);
		sort.setRowFilter(RowFilter.regexFilter(search, 0,1,2,3,4,5,6));
	}
	void addMovie(String record){
		try {
			fw=new FileWriter("Movies.txt",true);
			fw.write(record);
			fw.close();		
		} catch (Exception e) {
			System.err.println("Error addMovie: "+e.getMessage());
		}
	} 
	void updateMovies(JTable table){
		try {
			fw=new FileWriter("Movies.txt");
			for(int q=0;q<table.getRowCount();q++){
				for(int w=0;w<table.getColumnCount();w++){
					fw.write(table.getValueAt(q, w)+"|");
				}fw.write("\n");
			}
			fw.close();		
		} catch (Exception e) {
			System.err.println("Error updateMovies: "+e.getMessage());
		}
	}
}
