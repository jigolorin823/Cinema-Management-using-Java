import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public class Reservation extends JFrame{
	JButton btnC1,btnC2,btnC3,btnC4;
	JComboBox cboCN;
	static ReservationPanel c;
	public Reservation() {
		int q = AdminCinemas.cin.getRecordCount()-1;
		cboCN = new JComboBox();
		for(int w=0;w<q;w++){
			cboCN.addItem("Cinema "+(w+1));
		}
		cboCN.setSelectedIndex(0);
		c = new ReservationPanel(cboCN.getSelectedIndex());
		
		cboCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(c);
				c = new ReservationPanel(cboCN.getSelectedIndex());
				add(c).setBounds(10,50,1180,620);
			}
		});
		setSize(1200,700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setVisible(true);
		
		add(cboCN).setBounds(10,10,90,50);
		
		add(c).setBounds(10,50,1180,620);
		
		
	}	
	void updateReservations(){
		int q = AdminCinemas.cin.getRecordCount()-1;
		cboCN.addItem("Cinema "+(q));
		cboCN.setSelectedIndex(0);
	}
	void setSelected(int num){
		cboCN.setSelectedIndex(num);
	}
}
