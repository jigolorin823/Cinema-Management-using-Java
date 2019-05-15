import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

public class AdminMenu extends JFrame{
	JButton btnMov, btnRes,btnSal,btnCin,btnBack;
	static AdminMovies mov;
	static AdminCinemas cin;
	static AdminReservations res;
	static AdminSales sal;
	public AdminMenu() {
		btnMov = new JButton("Movies");
		btnMov.setBackground(Color.LIGHT_GRAY);
		btnRes = new JButton("Reservations");
		btnRes.setBackground(Color.GRAY);
		btnSal = new JButton("Sales");
		btnSal.setBackground(Color.ORANGE);
		btnCin = new JButton("Cinemas");
		btnCin.setBackground(Color.GREEN);
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.CYAN);
		
		getContentPane().setBackground(Color.BLACK);
		setSize(1200,100);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocation(50,50);
		setResizable(false);
		setLayout(null);
		setVisible(true);
		
		add(btnMov).setBounds(10,10,120,50);
		add(btnRes).setBounds(140,10,120,50);
		add(btnCin).setBounds(270,10,120,50);
		add(btnSal).setBounds(400,10,120,50);
		add(btnBack).setBounds(1000,10,120,50);
		

		mov = new AdminMovies();
		mov.setBackground(Color.LIGHT_GRAY);
		cin = new AdminCinemas();
		cin.setBackground(Color.GREEN);
		res = new AdminReservations();
		res.setBackground(Color.GRAY);
		sal = new AdminSales();
		sal.setBackground(Color.ORANGE);
		
		cin.setVisible(false);
		res.setVisible(false);
		sal.setVisible(false);
		mov.setVisible(false);
		
		add(cin).setBounds(10, 70, 1180, 590);
		add(res).setBounds(10, 70, 1180, 590);
		add(sal).setBounds(10, 70, 1180, 590);
		add(mov).setBounds(10, 70, 1180, 590);
		
		btnCin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getHeight()==100){
					setSize(1200,700);
				}
				cin.setVisible(true);
				res.setVisible(false);
				sal.setVisible(false);
				mov.setVisible(false);
			}
		});
		btnRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getHeight()==100){
					setSize(1200,700);
				}
				cin.setVisible(false);
				res.setVisible(true);
				sal.setVisible(false);
				mov.setVisible(false);
			}
		});
		btnSal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getHeight()==100){
					setSize(1200,700);
				}
				cin.setVisible(false);
				res.setVisible(false);
				sal.setVisible(true);
				mov.setVisible(false);
			}
		});
		btnMov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getHeight()==100){
					setSize(1200,700);
				}
				cin.setVisible(false);
				res.setVisible(false);
				sal.setVisible(false);
				mov.setVisible(true);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home.g.setVisible(true);
				Home.am.setVisible(false);
				
			}
		});
	}
	
}
