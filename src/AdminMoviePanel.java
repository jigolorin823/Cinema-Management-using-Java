import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class AdminMoviePanel extends JPanel{
	JLabel lblTitle,lblSyn,lblImg,lblRat,lblDur,lblGen;
	JTextField txtTitle,txtRat,txtDur,txtGen;
	JTextArea txtSyn;
	JButton btnEdit;
	ImageIcon icon;
	Image w;
	String id,title,syn,rat,dur,gen,pos;
	int num;
	public AdminMoviePanel() {
		
	}
	public AdminMoviePanel(int num) {
		id = AdminMovies.table.getValueAt(num, 0).toString();
		title = AdminMovies.table.getValueAt(num, 1).toString();
		syn = AdminMovies.table.getValueAt(num, 2).toString();
		rat = AdminMovies.table.getValueAt(num, 3).toString();
		dur = AdminMovies.table.getValueAt(num, 4).toString();
		gen = AdminMovies.table.getValueAt(num, 5).toString();
		pos = AdminMovies.table.getValueAt(num, 6).toString();
		
		TitledBorder tlBord = new TitledBorder(id);
		
		setBorder(tlBord);
		setLayout(null);
		lblTitle = new JLabel("Title");
		lblSyn = new JLabel("Synopsis");
		lblImg = new JLabel("");
		lblRat = new JLabel("Rating");
		lblDur = new JLabel("Duration");
		lblGen = new JLabel("Genre");
		
		txtTitle = new JTextField();
		txtTitle.setText(title);
		txtTitle.setEditable(false);
		txtRat = new JTextField();
		txtRat.setText(rat);
		txtRat.setEditable(false);
		txtDur = new JTextField();
		txtDur.setText(dur);
		txtDur.setEditable(false);
		txtGen = new JTextField();
		txtGen.setText(gen);
		txtGen.setEditable(false);
		txtSyn = new JTextArea();
		txtSyn.setEditable(false);
		txtSyn.setLineWrap(true);
		txtSyn.setWrapStyleWord(true);
		txtSyn.setText(syn);
		
		icon = new ImageIcon(pos);
		w = icon.getImage().getScaledInstance(120, 180, Image.SCALE_DEFAULT);
		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(w));
		
		
		btnEdit = new JButton("Edit Movie");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddMovieFrame(num);
			
				
				
				
			}
		});
		
		
		
		setLayout(null);
//		add(lblCinNum).setBounds(10,10,100,40);
		add(lblTitle).setBounds(10,60,80,40);
		add(txtTitle).setBounds(100,60,150,40);
		add(lblSyn).setBounds(10,110,80,40);
		add(txtSyn).setBounds(10,150,200,190);
		add(lblImg).setBounds(260,10,150,280);
		add(lblRat).setBounds(420,10,80,40);
		add(txtRat).setBounds(510,10,80,40);
		add(lblDur).setBounds(420,60,80,40);
		add(txtDur).setBounds(510,60,80,40);
		add(lblGen).setBounds(420,110,80,40);
		add(txtGen).setBounds(510,110,80,40);
		add(btnEdit).setBounds(700,100,200,50);
		
		
	}
//	void updateSeats() {
//		switch(num) {
//		case 1: {Reservation.c1.getSeats();break;}
//		case 2: {Reservation.c2.getSeats();break;}
//		case 3: {Reservation.c3.getSeats();break;}
//		case 4: {Reservation.c4.getSeats();break;}
//		}
//	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setVisible(true);
//		frame.setSize(500, 500);
//		frame.setLocationRelativeTo(null);
//		
//		AdminCinemaInfoPanel asd = new AdminCinemaInfoPanel(1);
//		frame.add(asd);
//	}
}
