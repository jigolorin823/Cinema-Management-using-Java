import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import org.omg.PortableServer.ServantRetentionPolicyValue;

public class Home extends JFrame{
	JPanel screen,qwe,main;
	CinemaPanel[] c;
	JButton btnAdmin;
	JLabel lblTitle;
	JScrollPane scroll;
	static Home g;
	static Reservation cin;
	static AdminMenu am;
	static LoginUI lg;
	static TicketReservation tct;
	Home(){
		DateTime date = new DateTime("date2");
		DateTime time = new DateTime("time");
		DateTime day = new DateTime("day");
		qwe = new JPanel();
		qwe.setLayout(new GridLayout(1,3));
		qwe.add(date);
		qwe.add(time);
		qwe.add(day);
		main = new JPanel();
		
		lblTitle = new JLabel("SIHNEHMAHBEYHBEH");
		lblTitle.setFont(new Font("Courier", Font.BOLD, 20));
		
		btnAdmin = new JButton("Login as Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.lg.setVisible(true);
				g.setVisible(false);
			}
		});
		
		int q = AdminCinemas.cin.getRecordCount();
		
		screen = new JPanel();
		screen.setPreferredSize(new Dimension((q-1)*300,600));
		screen.setLayout(null);
		
		
		
		c = new CinemaPanel[q];
		
		for(int w =0;w<q-1;w++){
			c[w] = new CinemaPanel(w);
			screen.add(c[w]).setBounds(10+(w*295),10,295,590);
			
		}
		
		scroll = new JScrollPane(screen);
		scroll.setPreferredSize(new Dimension(1180, 600));
		
		
		
		
		
		main.setBackground(Color.CYAN);
		setVisible(true);
		setSize(1200,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		main.setLayout(null);
		main.add(btnAdmin).setBounds(1000,10,150,50);
		main.add(lblTitle).setBounds(500,10,200,50);
		main.add(scroll).setBounds(10,70,1180,600);	
		main.add(qwe).setBounds(10,10,400,50);
		
		add(main).setBounds(0,0,1200,750);
		
	}
//	void updateFrame(){
//		c1 = new CinemaPanel(1);
//		c2 = new CinemaPanel(2);
//		c3 = new CinemaPanel(3);
//		c4 = new CinemaPanel(4);
//	}
	public static void main(String[] args) {
		
		
		am = new AdminMenu();
		am.setVisible(false);
		cin = new Reservation();
		cin.setVisible(false);
		lg = new LoginUI();
		lg.setVisible(false);
		tct = new TicketReservation();
		tct.setVisible(false);
		g = new Home();
		
	}
	void updateHome(){
		int q = AdminCinemas.cin.getRecordCount();
		screen.removeAll();
		screen.setPreferredSize(new Dimension((q-1)*300,600));
		screen.setLayout(null);
		c = new CinemaPanel[q];
		for(int w =0;w<q-1;w++){
			c[w] = new CinemaPanel(w);
			screen.add(c[w]).setBounds(10+(w*295),10,295,590);
			
		}
	}

	
}
