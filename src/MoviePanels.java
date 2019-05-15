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


public class MoviePanels extends JPanel{
	JLabel lblTitle,lblSyn,lblImg,lblRat,lblDur,lblGen;
	JTextField txtTitle,txtRat,txtDur,txtGen;
	JTextArea txtSyn;
	JButton btnEdit;
	ImageIcon icon;
	Image w;
	String id,title,syn,rat,dur,gen,pos;
	int num;
	public MoviePanels() {
		
	}
	public MoviePanels(int num,int cinNum) {
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
		txtSyn.setLineWrap(true);
		txtSyn.setEditable(false);
		txtSyn.setWrapStyleWord(true);
		txtSyn.setText(syn);
		
		icon = new ImageIcon(pos);
		w = icon.getImage().getScaledInstance(120, 180, Image.SCALE_DEFAULT);
		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(w));
		
		
		btnEdit = new JButton("Select");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ch = JOptionPane.showConfirmDialog(null, "Confirm Change?", "Change", JOptionPane.YES_NO_OPTION);
				if(ch==JOptionPane.YES_OPTION){
					AdminCinemas.table.setValueAt(id, cinNum, 1);
					AdminCinemas.cin.updateCinemas(AdminCinemas.table);
					AdminCinemas.cin.updateTable();
					AdminMenu.cin.updateCinemas();
					Home.g.updateHome();
					AdminCinemaInfoPanel.frame.dispose();
				}
			
				
				
				
			}
		});
		
		
		
		setLayout(null);
//		add(lblCinNum).setBounds(10,10,100,40);
		add(lblImg).setBounds(10,10,150,280);
		add(lblTitle).setBounds(170,10,80,40);
		add(txtTitle).setBounds(260,10,150,40);
		add(lblSyn).setBounds(170,60,80,40);
		add(txtSyn).setBounds(170,100,200,190);		
		add(lblRat).setBounds(420,10,80,40);
		add(txtRat).setBounds(510,10,80,40);
		add(lblDur).setBounds(420,60,80,40);
		add(txtDur).setBounds(510,60,80,40);
		add(lblGen).setBounds(420,110,80,40);
		add(txtGen).setBounds(510,110,80,40);
		add(btnEdit).setBounds(600,200,100,50);
		
		
	}
	MoviePanels(int num){
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
		txtRat = new JTextField();
		txtRat.setText(rat);
		txtDur = new JTextField();
		txtDur.setText(dur);
		txtGen = new JTextField();
		txtGen.setText(gen);
		txtSyn = new JTextArea();
		txtSyn.setLineWrap(true);
		txtSyn.setWrapStyleWord(true);
		txtSyn.setText(syn);
		
		icon = new ImageIcon(pos);
		w = icon.getImage().getScaledInstance(120, 180, Image.SCALE_DEFAULT);
		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(w));
		
		
		btnEdit = new JButton("Select");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ch = JOptionPane.showConfirmDialog(null, "Confirm Change?", "Change", JOptionPane.YES_NO_OPTION);
				if(ch==JOptionPane.YES_OPTION){
					AdminCinemas.add.txtTitle.setText(title);
					AdminCinemas.add.setMovId(Integer.parseInt(id));
					AdminCinemaInfoPanel.frame.dispose();
				}
			
				
				
				
			}
		});
		
		
		
		setLayout(null);
//		add(lblCinNum).setBounds(10,10,100,40);
		add(lblImg).setBounds(10,10,150,280);
		add(lblTitle).setBounds(170,10,80,40);
		add(txtTitle).setBounds(260,10,150,40);
		add(lblSyn).setBounds(170,60,80,40);
		add(txtSyn).setBounds(170,100,200,190);		
		add(lblRat).setBounds(420,10,80,40);
		add(txtRat).setBounds(510,10,80,40);
		add(lblDur).setBounds(420,60,80,40);
		add(txtDur).setBounds(510,60,80,40);
		add(lblGen).setBounds(420,110,80,40);
		add(txtGen).setBounds(510,110,80,40);
		add(btnEdit).setBounds(600,200,100,50);
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
