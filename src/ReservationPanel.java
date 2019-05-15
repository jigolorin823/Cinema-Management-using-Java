import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public class ReservationPanel extends JPanel{
	JLabel lblTitle,lblDate,lblTime,lblSyn,lblPrice,lblRat,lblDur,lblGenre,lblImage;
	JComboBox cboMon,cboDay,cboYr,cboTime;
	JTextField txtTitle,txtPrice,txtRat,txtDur,txtGenre;
	JTextArea txtSyn;
	TitledBorder tlBord;
	boolean seat[][];
	JToggleButton btnseats[][];
	JButton btnRes,btnBack;
	ImageIcon icon;
	Image w;
	int numSeats, num;
	String reservations,numTime;
	Seats seat1,seat2,seat3,seat4,seat5;
	ReservationPanel(int num){
		this.num = num;
		if(AdminCinemas.table.getValueAt(num, 4).toString().equals("Active")){
			int movID = Integer.parseInt(AdminCinemas.table.getValueAt(num, 1).toString());
			movID--;
			
			
			
			lblTitle = new JLabel("Title ");
			lblDate = new JLabel("Date ");
			lblTime = new JLabel("Time ");
			lblSyn = new JLabel("Synopsis ");
			lblPrice = new JLabel("Price ");
			lblRat = new JLabel("Rating ");
			lblDur = new JLabel("Duration ");
			lblGenre = new JLabel("Genre ");
			
			txtTitle = new JTextField();
			txtTitle.setText(AdminMovies.table.getValueAt(movID, 1).toString());
			txtTitle.setEditable(false);
			txtPrice = new JTextField();
			txtPrice.setText(AdminCinemas.table.getValueAt(num, 2).toString());
			txtPrice.setEditable(false);
			txtSyn = new JTextArea();
			txtSyn.setEditable(false);
			txtSyn.setText(AdminMovies.table.getValueAt(movID, 2).toString());
			txtSyn.setLineWrap(true);
			txtSyn.setWrapStyleWord(true);		
			txtRat = new JTextField();
			txtRat.setText(AdminMovies.table.getValueAt(movID, 3).toString());
			txtRat.setEditable(false);
			txtDur = new JTextField();
			txtDur.setText(AdminMovies.table.getValueAt(movID, 4).toString());
			txtDur.setEditable(false);
			txtGenre = new JTextField();
			txtGenre.setText(AdminMovies.table.getValueAt(movID, 5).toString());	
			txtGenre.setEditable(false);
			
			cboMon = new JComboBox();
			cboMon.addItem("January");
			cboMon.addItem("February");
			cboMon.addItem("March");
			cboMon.addItem("April");
			cboMon.addItem("May");
			cboMon.addItem("June");
			cboMon.addItem("July");
			cboMon.addItem("August");
			cboMon.addItem("September");
			cboMon.addItem("October");
			cboMon.addItem("November");
			cboMon.addItem("December");
			cboMon.setSelectedIndex(0);
			cboYr = new JComboBox();
			for(int q=2017;q<=2050;q++){
				cboYr.addItem(q);
			}
			cboYr.setSelectedIndex(0);
			cboDay = new JComboBox();
			
			cboTime = new JComboBox();
			cboTime.addItem("9:00AM");
			cboTime.addItem("12:00PM");
			cboTime.addItem("3:00PM");
			cboTime.addItem("6:00PM");
			cboTime.addItem("9:00PM");
			
			setDays();
			setDate();
			seat1 = new Seats(num,cboTime.getItemAt(0).toString(),getDate());
			seat2 = new Seats(num,cboTime.getItemAt(1).toString(),getDate());
			seat3 = new Seats(num,cboTime.getItemAt(2).toString(),getDate());
			seat4 = new Seats(num,cboTime.getItemAt(3).toString(),getDate());
			seat5 = new Seats(num,cboTime.getItemAt(4).toString(),getDate());
			hideSeats();
//			cboTime.setSelectedIndex(0);
//			getSeats();
			cboTime.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cboTime.getSelectedItem().equals("9:00AM")){
						seat1.setVisible(true);
						seat2.setVisible(false);
						seat3.setVisible(false);
						seat4.setVisible(false);
						seat5.setVisible(false);
					}
					else if(cboTime.getSelectedItem().equals("12:00PM")){
						seat1.setVisible(false);
						seat2.setVisible(true);
						seat3.setVisible(false);
						seat4.setVisible(false);
						seat5.setVisible(false);					
					}
					else if(cboTime.getSelectedItem().equals("3:00PM")){
						seat1.setVisible(false);
						seat2.setVisible(false);
						seat3.setVisible(true);
						seat4.setVisible(false);
						seat5.setVisible(false);
					}
					else if(cboTime.getSelectedItem().equals("6:00PM")){
						seat1.setVisible(false);
						seat2.setVisible(false);
						seat3.setVisible(false);
						seat4.setVisible(true);
						seat5.setVisible(false);
					}
					else if(cboTime.getSelectedItem().equals("9:00PM")){
						seat1.setVisible(false);
						seat2.setVisible(false);
						seat3.setVisible(false);
						seat4.setVisible(false);
						seat5.setVisible(true);
					}
				}
			});
			cboMon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setDays();
					getSeats();
					hideSeats();
				}
			});
			cboYr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setDays();
					getSeats();
					hideSeats();
				}
			});
			cboDay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getSeats();
					hideSeats();
				}
			});
			
			icon = new ImageIcon(AdminMovies.table.getValueAt(movID, 6).toString());
			w = icon.getImage().getScaledInstance(275, 350, Image.SCALE_DEFAULT);
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(w));
			
		
			
			
			
			
			btnRes = new JButton("Reserve");
			btnRes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(cboTime.getSelectedIndex()){
					case 0:{numSeats = seat1.getNumSeats();reservations=seat1.getReservations();numTime=cboTime.getItemAt(0).toString();break;}
					case 1:{numSeats = seat2.getNumSeats();reservations=seat2.getReservations();numTime=cboTime.getItemAt(1).toString();break;}
					case 2:{numSeats = seat3.getNumSeats();reservations=seat3.getReservations();numTime=cboTime.getItemAt(2).toString();break;}
					case 3:{numSeats = seat4.getNumSeats();reservations=seat4.getReservations();numTime=cboTime.getItemAt(3).toString();break;}
					case 4:{numSeats = seat5.getNumSeats();reservations=seat5.getReservations();numTime=cboTime.getItemAt(4).toString();break;}
					}
					if(numSeats==0){
						JOptionPane.showMessageDialog(null, "Select Seats first before reserving");
					}else {
						Home.tct.setValues(num,numSeats,numTime,reservations, getDate());
						Home.tct.setVisible(true);
						Home.cin.setVisible(false);
						
					}
						
					
				}
			});
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home.g.setVisible(true);
					Home.cin.setVisible(false);
					
				}
			});
			
			
			setLayout(null);
			add(lblTitle).setBounds(20,20,60,30);
			add(txtTitle).setBounds(80,20,200,30);
			add(lblPrice).setBounds(20,60,60,30);
			add(txtPrice).setBounds(80,60,60,30);
			add(lblRat).setBounds(20,100,50,30);
			add(txtRat).setBounds(70,100,80,30);
			add(lblGenre).setBounds(160,100,50,30);
			add(txtGenre).setBounds(220,100,150,30);
			add(lblDur).setBounds(20,140,60,30);
			add(txtDur).setBounds(80,140,80,30);
			add(lblDate).setBounds(20,180,60,30);
			add(cboMon).setBounds(80,180,100,30);
			add(cboDay).setBounds(180,180,60,30);
			add(cboYr).setBounds(240,180,80,30);
			add(lblTime).setBounds(20,220,60,30);
			add(cboTime).setBounds(80,220,80,30);		
			add(lblSyn).setBounds(400,80,60,30);
			add(txtSyn).setBounds(460,10,300,200);
			add(lblImage).setBounds(850,0,250,230);
			add(seat1).setBounds(10,260,1150,300);
			add(seat2).setBounds(10,260,1150,300);
			add(seat3).setBounds(10,260,1150,300);
			add(seat4).setBounds(10,260,1150,300);
			add(seat5).setBounds(10,260,1150,300);		
			add(btnRes).setBounds(490,570,100,40);
			add(btnBack).setBounds(590,570,100,40);
		}
		else {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Home.cin.setVisible(false);
					Home.g.setVisible(true);
					
				}
			});
			setLayout(null);
			icon = new ImageIcon("Images/image1.jpg");
			w = icon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(w));
			add(lblImage).setBounds(200,0,800,600);
			add(btnBack).setBounds(10,300,100,50);
		}
		
		
	}
	void setDays(){
		Vector d31 = new Vector();
		d31.add("January");
		d31.add("March");
		d31.add("May");
		d31.add("July");
		d31.add("August");
		d31.add("October");
		d31.add("December");
		cboDay.removeAllItems();
		if(cboMon.getSelectedItem().toString().equals("February")){
			if(Integer.parseInt(cboYr.getSelectedItem().toString())%4==0){
				for(int q=01;q<=29;q++){
					cboDay.addItem(q);
				}
			}else{
				for(int q=01;q<=28;q++){
					cboDay.addItem(q);
				}
			}
			
		}else if(d31.contains(cboMon.getSelectedItem().toString())){
			for(int q=01;q<=31;q++){
				cboDay.addItem(q);
			}
		}else{
			for(int q=01;q<=30;q++){
				cboDay.addItem(q);
			}
		}
	}
	void setDate(){
		DateTime dt = new DateTime("date");
		String date = dt.getText();
		String date2="";
		for(int q=0;q<cboYr.getItemCount();q++){
			for(int w=0;w<cboMon.getItemCount();w++){
				for(int e=0;e<cboDay.getItemCount();e++){
					date2=cboMon.getItemAt(w)+" "+cboDay.getItemAt(e)+" "+cboYr.getItemAt(q);
					if(date2.equals(date)){
						cboMon.setSelectedIndex(w);
						cboYr.setSelectedIndex(q);
						setDays();
						cboDay.setSelectedIndex(e);
						break;
					}
				}
			}
		}
//		cboTime.setSelectedIndex(0);
		
	}
	String getDate(){
		String date = cboMon.getSelectedItem()+" "+cboDay.getSelectedItem()+" "+cboYr.getSelectedItem();
		return date;
	}
	void getSeats(){
		seat1.getOnDate(getDate());
		seat2.getOnDate(getDate());
		seat3.getOnDate(getDate());
		seat4.getOnDate(getDate());
		seat5.getOnDate(getDate());
		seat1.setVisible(true);
		cboTime.setSelectedIndex(0);
	}
	void hideSeats(){
		seat1.setVisible(false);
		seat2.setVisible(false);
		seat3.setVisible(false);
		seat4.setVisible(false);
		seat5.setVisible(false);
	}
}
