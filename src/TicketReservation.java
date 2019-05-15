import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.InputMismatchException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import sun.awt.im.InputMethodJFrame;


public class TicketReservation extends JFrame{
	JLabel lblTic, lblType, lblCin,lblSeats, lblPrice, lblTotal, lblMoney, lblChange,lblImg,lblSalesID,lblDate;
	JTextField txtTic,txtCin,txtSeats,txtPrice,txtTotal,txtMoney,txtChange,txtSalesID,txtDate;
	JComboBox cboType;
	JButton btnConf,btnCancel;
	String hold="", numTime,date,reservations;
	DateTime dt;
	ImageIcon icon;
	Image w;
	
	int num,numSeats;
	void setValues(int num,int numSeats,String numTime,String reservations,String date) {
		this.numTime = numTime;
		this.num=num;
		this.reservations=reservations;
		this.date = date;
		this.numSeats=numSeats;
		
		txtTic.setText(numSeats+"");
		txtCin.setText((num+1)+"");
		txtSeats.setText(reservations);
		txtPrice.setText(AdminCinemas.table.getValueAt(num, 2).toString());
		txtTotal.setText((numSeats*Double.parseDouble(AdminCinemas.table.getValueAt(num, 2).toString()))+"");
		txtSalesID.setText(AdminReservations.tic.getRecordCount()+"");
		icon = new ImageIcon(AdminMovies.table.getValueAt(num, 6).toString());
		w = icon.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
		lblImg.setIcon(new ImageIcon(w));
		txtMoney.setText("0.00");
		txtDate.setText(date);
	}
	TicketReservation(){
		
		double cash=0.00;	
		lblTic = new JLabel("No. of Tickets");
		lblType = new JLabel("Type of Ticket");
		lblCin = new JLabel("Cinema No.");
		lblSeats = new JLabel("Reservations");
		lblPrice = new JLabel("Price");
		lblTotal = new JLabel("Total");
		lblMoney = new JLabel("Money");
		lblChange = new JLabel("Change");
		lblSalesID = new JLabel("Sales ID");
		lblDate = new JLabel("Date");
		lblImg = new JLabel("");
		TitledBorder t = new TitledBorder("");
		lblImg.setBorder(t);
		
		cboType = new JComboBox();
		cboType.addItem("Regular");
		cboType.addItem("Discounted");
		

		
		
		txtTic = new JTextField();
		
		txtTic.setEditable(false);
		txtCin = new JTextField();
		
		txtCin.setEditable(false);
		txtSeats = new JTextField();
		
		txtSeats.setEditable(false);
		txtPrice = new JTextField();
		
		txtPrice.setEditable(false);
		txtTotal = new JTextField();
		
		txtTotal.setEditable(false);
		txtMoney = new JTextField();
		txtChange = new JTextField();
		txtChange.setEditable(false);
		txtDate = new JTextField();
		
		txtDate.setEditable(false);
		txtSalesID = new JTextField();
		
		txtSalesID.setEditable(false);
		txtMoney.setText(cash+"");
		txtMoney.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				char c = e.getKeyChar();
		           if (!(Character.isDigit(c) ||
		              (c == KeyEvent.VK_BACK_SPACE) ||
		              (c == KeyEvent.VK_DELETE) ||
		              (c == KeyEvent.VK_PERIOD))){
		                e.consume();
		              }
		           else if (txtMoney.getText().equals("")){
		        	   txtMoney.setText("0");
		        	   e.consume();
		           }
		           double mon, tot, cha = 0.0;
					mon = Double.parseDouble(txtMoney.getText());
					tot = Double.parseDouble(txtTotal.getText());
//					JOptionPane.showMessageDialog(null, mon);
					cha = mon-tot;
					txtChange.setText(cha+"");
				
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cboType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboType.getSelectedItem().equals("Discounted")){
					txtTotal.setText((numSeats*Double.parseDouble(AdminCinemas.table.getValueAt(num, 2).toString())*0.8)+"");
				}
				else {
					txtTotal.setText(AdminCinemas.table.getValueAt(num, 2).toString());
				}
				
			}
		});
		
		
		btnConf = new JButton("Purchase");
		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ch = JOptionPane.showConfirmDialog(null, "Confirm Purchase?", "Purchase", JOptionPane.YES_NO_OPTION);
				if(ch==JOptionPane.YES_OPTION){
					double tot = Double.parseDouble(txtTotal.getText()),mon=Double.parseDouble(txtMoney.getText());
					if(tot<=mon){
						printReceipt();
						//inf.updateSeats(seats,num,numTime);
						AdminReservations.tic.addRecord(getRecord());
						Home.tct.setVisible(false);
						Home.g.setVisible(true);
						AdminReservations.tic.updateTable();
						Reservation.c.getSeats();
						AdminMenu.res.updateTable();
//						switch(num){
//						case 1: {Reservation.c1.getSeats();break;}
//						case 2: {Reservation.c2.getSeats();break;}
//						case 3: {Reservation.c3.getSeats();break;}
//						case 4: {Reservation.c4.getSeats();break;}
//						}
						
					}else
						JOptionPane.showMessageDialog(null, "Money is insufficient");
					
					
				}
			}
		});
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.tct.setVisible(false);
				Home.cin.setVisible(true);
			}
		});
		
		setSize(600,650);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setVisible(true);
		
		add(lblSalesID).setBounds(10,10,100,40);
		add(txtSalesID).setBounds(110,10,150,40);
		add(lblDate).setBounds(10,70,100,40);
		add(txtDate).setBounds(110,70,150,40);
		add(lblTic).setBounds(10,130,100,40);
		add(txtTic).setBounds(110,130,150,40);
		add(lblType).setBounds(10,190,100,40);
		add(cboType).setBounds(110,190,150,40);
		add(lblCin).setBounds(10,250,100,40);
		add(txtCin).setBounds(110,250,150,40);
		add(lblPrice).setBounds(10,310,100,40);
		add(txtPrice).setBounds(110,310,150,40);
		add(lblTotal).setBounds(10,370,100,40);
		add(txtTotal).setBounds(110,370,150,40);
		add(lblMoney).setBounds(10,430,100,40);
		add(txtMoney).setBounds(110,430,150,40);
		add(lblChange).setBounds(10,490,100,40);
		add(txtChange).setBounds(110,490,150,40);
		add(lblImg).setBounds(300,20,200,300);
		add(lblSeats).setBounds(280,370,100,40);
		add(txtSeats).setBounds(330,430,150,40);
		add(btnConf).setBounds(10,550,100,40);
		add(btnCancel).setBounds(110,550,100,40);
	}
	String getRecord(){
		hold="";
		hold+=txtSalesID.getText()+"|"+txtTic.getText()+"|"+cboType.getSelectedItem().toString()+"|"+txtCin.getText()+"|"+numTime+"|"+txtSeats.getText()+"|"+txtTotal.getText()+"|"+date+"|Active\n";
		return hold;
	}
	void printReceipt() {
		String hold="";
		DateTime date = new DateTime("date");
		DateTime time = new DateTime("time");
		hold= "\t\t\t\tSihnehmahBeyhbeh\n"
				+ "\t\t\t\t\tDavao City\n"
				+ "\t\t"+date.getText()+" "+time.getText()
				+ "\n\n\t\tSales ID: "+txtSalesID.getText()
				+ "\n\t\t"+AdminMovies.table.getValueAt(num, 1).toString()
				+ "\n\t\tCinema "+(num+1)
				+ "\n\t\t"
				+ "\n\t\tNo. of Tickets: "+txtTic.getText()
				+ "\n\t\tSeat Reservations: "+reservations
				+ "\n\t\tTotal: "+txtTotal.getText()
				+ "\n\t\tCash Rendered: "+txtMoney.getText()
				+ "\n\t\tChange: "+txtChange.getText()
				+ "\n\tThis serves as an official receipt."
				+ "\nAmusement and Cultural Tax included."
				+ "\nValid only on the screening details included.";
		JOptionPane.showMessageDialog(null, hold);
	}
}
