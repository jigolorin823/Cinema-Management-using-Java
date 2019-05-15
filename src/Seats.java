import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public class Seats extends JPanel{
	TitledBorder tlBord;
	Vector seat;
	JToggleButton[] btnseats;
	int numSeats,row,cap,avail;
	JLabel lblAvail,lblSNum;
	JTextField txtAvail,txtSNum;
	JPanel st;
	int num;
	String numTime, date;
	Seats(int num,String numTime,String date){
		this.num = num;
		this.numTime = numTime;
		this.date = date;
		avail=0;
		cap=Integer.parseInt(AdminCinemas.table.getValueAt(num, 3).toString());
		row=cap/10;
		
		st = new JPanel();
		
		lblAvail = new JLabel("Available Seats");
		lblSNum = new JLabel("No.of Seats");
		
		txtAvail = new JTextField();	
		txtAvail.setEditable(false);
		txtSNum = new JTextField();
		txtSNum.setText(numSeats+"");
		txtSNum.setEditable(false);
		
		tlBord = new TitledBorder("Seats");
		tlBord.setTitleJustification(TitledBorder.CENTER);
		tlBord.setTitleFont(new Font("Arial", Font.ITALIC, 20));
		st.setBorder(tlBord);
		st.setLayout(new GridLayout(row, 10));
		
		seat=AdminReservations.tic.getReservations(numTime, num+1, date);
		btnseats = new JToggleButton[cap];
		for (int i = 0; i < btnseats.length; i++) {
			
				btnseats[i] = new JToggleButton((i+1)+"");
				btnseats[i].setBackground(Color.GREEN);
				if(seat.contains((i+1)+"")){
					btnseats[i].setSelected(true);
					btnseats[i].setEnabled(false);
				}else{
					btnseats[i].setSelected(false);
					avail++;
				}
				btnseats[i].addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						for (int i = 0; i < btnseats.length; i++) {
							
								if(e.getSource().equals(btnseats[i])){
									if(e.getStateChange()==ItemEvent.SELECTED){
								        numSeats++;
//								        seat[i][j]=true;
								      } else if(e.getStateChange()==ItemEvent.DESELECTED){
								        numSeats--;
//								        seat[i][j]=false;
								      }
								}
								txtSNum.setText(numSeats+"");
							
						}
						
					}
				});		
				txtAvail.setText(avail+"");
				st.add(btnseats[i]);
			
		}
		
		setLayout(null);
		add(st).setBounds(10,10,1130,250);
		add(lblAvail).setBounds(20,260,100,30);
		add(txtAvail).setBounds(120,260,40,30);
		add(lblSNum).setBounds(1000,260,80,30);
		add(txtSNum).setBounds(1080,260,50,30);
	}
	int getNumSeats(){
		return numSeats;
	}
//	boolean[][] getSeat(){
//		return seat;
//	}
	String getReservations(){
		String reservations="";
		for (int i = 0; i < btnseats.length; i++) {
			if(btnseats[i].isEnabled()){
				if(btnseats[i].isSelected()){
					reservations+=btnseats[i].getText()+",";
				}
			}
			
		}	
		return reservations;
	}
	void getOnDate(String date2){
		
		st.removeAll();
		cap=Integer.parseInt(AdminCinemas.table.getValueAt(num, 3).toString());
		row=cap/10;
		avail =0;
		numSeats=0;
		seat=AdminReservations.tic.getReservations(numTime, num+1, date2);
		btnseats = new JToggleButton[cap];
		for (int i = 0; i < btnseats.length; i++) {
			
				btnseats[i] = new JToggleButton((i+1)+"");
				btnseats[i].setBackground(Color.GREEN);
				if(seat.contains((i+1)+"")){
					btnseats[i].setSelected(true);
					btnseats[i].setEnabled(false);
				}else{
					btnseats[i].setSelected(false);
					avail++;
				}
				btnseats[i].addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						for (int i = 0; i < btnseats.length; i++) {
							
								if(e.getSource().equals(btnseats[i])){
									if(e.getStateChange()==ItemEvent.SELECTED){
								        numSeats++;
//								        seat[i][j]=true;
								      } else if(e.getStateChange()==ItemEvent.DESELECTED){
								        numSeats--;
//								        seat[i][j]=false;
								      }
								}
								txtSNum.setText(numSeats+"");
							
						}
						
					}
				});		
				txtAvail.setText(avail+"");
				st.add(btnseats[i]);
		}
	}
}
