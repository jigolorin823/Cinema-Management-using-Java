import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CinemaPanel extends JPanel{
	private TitledBorder tlBord;
	private JButton btn;
	private JLabel lblSyp,lblAvail;
	private JTextArea txtSyp;
	private JTextField txtAvail;
	private int cinemaNum;
	static Reservation cin;
	ImageIcon icon;
	Image w;
	int movID;
	CinemaPanel(int num) {
		if(AdminCinemas.table.getValueAt(num, 4).toString().equals("Active")){
			movID = Integer.parseInt(AdminCinemas.table.getValueAt(num, 1).toString());
			icon = new ImageIcon(AdminMovies.table.getValueAt(movID-1, 6).toString());
			w = icon.getImage().getScaledInstance(275, 350, Image.SCALE_DEFAULT);
			
			btn = new JButton("");
			btn.setIcon(new ImageIcon(w));
			lblSyp = new JLabel("Sypnosis");
			
			txtSyp = new JTextArea(AdminMovies.table.getValueAt(movID-1, 2).toString());
			txtSyp.setEditable(false);
			txtSyp.setLineWrap(true);
			txtSyp.setWrapStyleWord(true);
			cinemaNum=num+1;
			tlBord = new TitledBorder("Cinema "+cinemaNum);
			
			setBorder(tlBord);
			setLayout(null);
			add(btn).setBounds(10,20,275,350);
			add(lblSyp).setBounds(10,360,80,50);
			add(txtSyp).setBounds(10,400,275,160);
//			add(lblAvail).setBounds(10,560,100,30);
//			add(txtAvail).setBounds(110,560,30,30);
			
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home.g.setVisible(false);
					Home.cin.setVisible(true);
					Home.cin.setSelected(num);
					
					
				}
			});
		} else {
			icon = new ImageIcon("Images/none.png");
			w = icon.getImage().getScaledInstance(275, 350, Image.SCALE_DEFAULT);
			
			btn = new JButton("");
			btn.setIcon(new ImageIcon(w));
			lblSyp = new JLabel("Sypnosis");
			
			txtSyp = new JTextArea("UNDER RENOVATION");
			txtSyp.setEditable(false);
			txtSyp.setLineWrap(true);
			txtSyp.setWrapStyleWord(true);
			cinemaNum=num+1;
			tlBord = new TitledBorder("Cinema "+cinemaNum);
			
			setBorder(tlBord);
			setLayout(null);
			add(btn).setBounds(10,20,275,350);
			add(lblSyp).setBounds(10,360,80,50);
			add(txtSyp).setBounds(10,400,275,160);
//			add(lblAvail).setBounds(10,560,100,30);
//			add(txtAvail).setBounds(110,560,30,30);
			
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home.g.setVisible(false);
					Home.cin.setVisible(true);
					Home.cin.setSelected(num);
					
					
				}
			});
		}
		
	}/*
	void setTitle(String title){
		tlBord.setTitle(title);
	}
	void setButton(String name){
		btn = new JButton(name);
	}
	void setSypnosis(String syp){
		txtSyp.setText(syp);
	}
	void setCinemaNum(int num){
		cinemaNum=num;
	}*/
	
}
