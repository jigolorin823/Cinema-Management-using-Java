import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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


public class AdminCinemaInfoPanel extends JPanel{
	JLabel lblCinNum,lblImg,lblTitle,lblPrice,lblCap;
	static JTextField txtTitle,txtPrice,txtCap;
	JButton btnEdit,btnAct,btnMore,btnLess,btnMore2,btnLess2;
	static ImageIcon icon;
	Image w;
	int cinNum,movID,cap;
	double price;
	int num;
	static JFrame frame;
	public AdminCinemaInfoPanel() {
		cinNum = AdminCinemas.cin.getRecordCount();
		movID=1;
		price = 200.0;
		cap = 40;
		TitledBorder tlBord = new TitledBorder("Cinema "+cinNum);
		TitledBorder imgb = new TitledBorder("");
		setBorder(tlBord);
		setLayout(null);
		lblTitle = new JLabel("Title");
		lblPrice = new JLabel("Price");
		lblCap = new JLabel("Capacity");
		
		icon = new ImageIcon("Images/none.png");
		w = icon.getImage().getScaledInstance(180, 250, Image.SCALE_DEFAULT);
		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(w));
		lblImg.setBorder(imgb);
		
		txtTitle = new JTextField();
		txtTitle.setText("");
		txtTitle.setEditable(false);
		txtTitle.setEditable(false);
		txtPrice = new JTextField();
		txtPrice.setText(price+"");
		txtPrice.setEditable(false);
		txtCap = new JTextField();
		txtCap.setText(cap+"");
		txtCap.setEditable(false);
		
		btnEdit = new JButton("Change Movie");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Choose Movie");
				frame.setVisible(true);
				frame.setSize(1000, 600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				JButton btnCan = new JButton("Cancel");
				btnCan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						
					}
				});
				
				int q=AdminMovies.mov.getRecordCount()-1;
				JPanel pan = new JPanel();
				pan.setPreferredSize(new Dimension(890, q*300));
				pan.setLayout(null);
				MoviePanels[] movs = new MoviePanels[q];
				for(int w=0;w<q;w++){
					movs[w] = new MoviePanels(w);
					pan.add(movs[w]).setBounds(10,10+(w*300),860,300);
				}
				JScrollPane scroll = new JScrollPane(pan);
				scroll.setPreferredSize(new Dimension(900, 500));
				frame.add(btnCan).setBounds(820,5,80,40);
				frame.add(scroll).setBounds(50,50,900,500);
				
				
				
				
			}
		});
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hold="";
				hold = cinNum+"|"+movID+"|"+txtPrice.getText()+"|"+txtCap.getText()+"|";
				if(txtTitle.getText().equals("")){
					hold+="Inactive\n";
				} else {
					hold+="Active\n";
				}
				AdminCinemas.cin.addCinema(hold);
				JOptionPane.showMessageDialog(null,"Cinema Added");
				AdminCinemas.cin.updateTable();
				AdminCinemas.table.setModel(AdminCinemas.cin.mdl);
				AdminMenu.cin.updateCinemas();
				Home.g.updateHome();
				Home.cin.updateReservations();
				AdminCinemas.frame.dispose();
				
			}
		});
		JButton btnCncl = new JButton("Cancel");
		btnCncl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminCinemas.frame.dispose();
				
			}
		});
		btnMore = new JButton("+");
		btnMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int q = Integer.parseInt(txtCap.getText().toString());
				q++;
				txtCap.setText(q+"");
				
			}
		});
		
		btnLess = new JButton("-");
		btnLess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int q = Integer.parseInt(txtCap.getText().toString());
				q--;
				txtCap.setText(q+"");
				
			}
		});
		btnMore2 = new JButton("+");
		btnMore2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double q = Double.parseDouble(txtPrice.getText().toString());
				q+=5;
				txtPrice.setText(q+"");
				
			}
		});
		
		btnLess2 = new JButton("-");
		btnLess2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double q = Double.parseDouble(txtPrice.getText().toString());
				q-=5;
				txtPrice.setText(q+"");
				
			}
		});
		
		add(lblTitle).setBounds(10,10,80,40);
		add(txtTitle).setBounds(100,10,150,40);
		add(lblPrice).setBounds(10,60,80,40);
		add(txtPrice).setBounds(100,60,100,40);
		add(btnMore2).setBounds(100,100,50,20);
		add(btnLess2).setBounds(150,100,50,20);
		add(lblCap).setBounds(10,130,80,40);
		add(txtCap).setBounds(100,130,100,40);
		add(btnMore).setBounds(100,170,50,20);
		add(btnLess).setBounds(150,170,50,20);
		add(lblImg).setBounds(270,10,180,250);
		add(btnEdit).setBounds(40,280,150,40);
		add(btnAdd).setBounds(125,400,100,50);
		add(btnCncl).setBounds(275,400,100,50);
	}
	public AdminCinemaInfoPanel(int num) {
		if(AdminCinemas.table.getValueAt(num, 4).toString().equals("Active")){
			cinNum = Integer.parseInt(AdminCinemas.table.getValueAt(num, 0).toString());
			movID = Integer.parseInt(AdminCinemas.table.getValueAt(num, 1).toString());
			price = Double.parseDouble(AdminCinemas.table.getValueAt(num, 2).toString());
			cap = Integer.parseInt(AdminCinemas.table.getValueAt(num, 3).toString());
			
			TitledBorder tlBord = new TitledBorder("Cinema "+cinNum);
			
			setBorder(tlBord);
			setLayout(null);
			lblTitle = new JLabel("Title");
			lblPrice = new JLabel("Price");
			lblCap = new JLabel("Capacity");
			
			icon = new ImageIcon(AdminMovies.table.getValueAt(movID-1, 6).toString());
			w = icon.getImage().getScaledInstance(120, 180, Image.SCALE_DEFAULT);
			lblImg = new JLabel("");
			lblImg.setIcon(new ImageIcon(w));
			
			txtTitle = new JTextField();
			txtTitle.setText(AdminMovies.table.getValueAt(movID-1, 1).toString());
			txtTitle.setEditable(false);
			txtPrice = new JTextField();
			txtPrice.setText(price+"");
			txtPrice.setEditable(false);
			txtCap = new JTextField();
			txtCap.setText(cap+"");
			txtCap.setEditable(false);
			
			btnEdit = new JButton("Change Movie");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame = new JFrame("Choose Movie");
					frame.setVisible(true);
					frame.setSize(1000, 600);
					frame.setLayout(null);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					JButton btnCan = new JButton("Cancel");
					btnCan.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
							
						}
					});
					int q=AdminMovies.mov.getRecordCount()-1;
					JPanel pan = new JPanel();
					pan.setPreferredSize(new Dimension(890, q*300));
					pan.setLayout(null);
					MoviePanels[] movs = new MoviePanels[q];
					for(int w=0;w<q;w++){
						movs[w] = new MoviePanels(w,num);
						pan.add(movs[w]).setBounds(10,10+(w*300),860,300);
					}
					JScrollPane scroll = new JScrollPane(pan);
					scroll.setPreferredSize(new Dimension(900, 500));
					frame.add(btnCan).setBounds(820,5,80,40);
					frame.add(scroll).setBounds(50,50,900,500);
				
					
					
					
				}
			});
			btnAct = new JButton("Deactivate");
			btnAct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int ch = JOptionPane.showConfirmDialog(null, "Confirm Deactivation?", "Deactivate", JOptionPane.YES_NO_OPTION);
					if(ch==JOptionPane.YES_OPTION){
						AdminCinemas.table.setValueAt("Inactive", num, 4);
						AdminCinemas.cin.updateCinemas(AdminCinemas.table);
						AdminCinemas.cin.updateTable();
						AdminMenu.cin.updateCinemas();
						Home.g.updateHome();
					}
					
				}
			});
			btnMore = new JButton("+");
			btnMore.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					cap++;
					txtCap.setText(cap+"");
					AdminCinemas.table.setValueAt(cap+"", num, 3);
					AdminCinemas.cin.updateCinemas(AdminCinemas.table);
					AdminCinemas.cin.updateTable();
					Reservation.c.getSeats();
					AdminMenu.cin.updateCinemas();
				}
			});
			
			btnLess = new JButton("-");
			btnLess.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cap--;
					txtCap.setText(cap+"");
					AdminCinemas.table.setValueAt(cap+"", num, 3);
					AdminCinemas.cin.updateCinemas(AdminCinemas.table);
					AdminCinemas.cin.updateTable();
					Reservation.c.getSeats();
					AdminMenu.cin.updateCinemas();
				}
			});
			btnMore2 = new JButton("+");
			btnMore2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					price+=5;
					txtPrice.setText(price+"");
					AdminCinemas.table.setValueAt(price+"", num, 2);
					AdminCinemas.cin.updateCinemas(AdminCinemas.table);
					AdminCinemas.cin.updateTable();
//					Reservation.c.getSeats();
					AdminMenu.cin.updateCinemas();
				}
			});
			
			btnLess2 = new JButton("-");
			btnLess2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					price-=5;
					txtPrice.setText(price+"");
					AdminCinemas.table.setValueAt(price+"", num, 2);
					AdminCinemas.cin.updateCinemas(AdminCinemas.table);
					AdminCinemas.cin.updateTable();
//					Reservation.c.getSeats();
					AdminMenu.cin.updateCinemas();
				}
			});
			
			
			setLayout(null);
//			add(lblCinNum).setBounds(10,10,100,40);
			add(lblTitle).setBounds(10,60,80,40);
			add(txtTitle).setBounds(20,110,150,40);
			add(lblImg).setBounds(180,50,120,180);
			add(lblPrice).setBounds(320,60,80,40);
			add(txtPrice).setBounds(400,60,100,40);
			add(btnMore2).setBounds(400,100,50,20);
			add(btnLess2).setBounds(450,100,50,20);
			add(lblCap).setBounds(320,130,80,40);
			add(txtCap).setBounds(400,130,100,40);
			add(btnMore).setBounds(400,170,50,20);
			add(btnLess).setBounds(450,170,50,20);
			add(btnEdit).setBounds(700,50,200,50);
			add(btnAct).setBounds(700,100,200,50);
		} else {
			cinNum = Integer.parseInt(AdminCinemas.table.getValueAt(num, 0).toString());
			movID = Integer.parseInt(AdminCinemas.table.getValueAt(num, 1).toString());
			price = Double.parseDouble(AdminCinemas.table.getValueAt(num, 2).toString());
			cap = Integer.parseInt(AdminCinemas.table.getValueAt(num, 3).toString());
			
			TitledBorder tlBord = new TitledBorder("Cinema "+cinNum);
			
			setBorder(tlBord);
			setLayout(null);
			lblTitle = new JLabel("Title");
			lblPrice = new JLabel("Price");
			lblCap = new JLabel("Capacity");
			
			icon = new ImageIcon("Images/none.png");
			w = icon.getImage().getScaledInstance(120, 180, Image.SCALE_DEFAULT);
			lblImg = new JLabel("");
			lblImg.setIcon(new ImageIcon(w));
			
			txtTitle = new JTextField();
			txtTitle.setText("Inactive");
			txtTitle.setEditable(false);
			txtPrice = new JTextField();
			txtPrice.setText("N/A");
			txtPrice.setEditable(false);
			txtCap = new JTextField();
			txtCap.setText("N/A");
			txtCap.setEditable(false);
			
			btnEdit = new JButton("Change Movie");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				
					
					
					
				}
			});
			btnAct = new JButton("Activate");
			btnAct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int ch = JOptionPane.showConfirmDialog(null, "Confirm Activation?", "Activate", JOptionPane.YES_NO_OPTION);
					if(ch==JOptionPane.YES_OPTION){
						AdminCinemas.table.setValueAt("Active", num, 4);
						AdminCinemas.cin.updateCinemas(AdminCinemas.table);
						AdminCinemas.cin.updateTable();
						AdminMenu.cin.updateCinemas();
						Home.g.updateHome();
					}
					
				}
			});
			btnMore = new JButton("+");
//			btnMore.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					JOptionPane.showMessageDialog(null, AdminCinemas.table.getValueAt(num, 3));
//					int q = Integer.parseInt(txtCap.getText().toString());
//					q++;
//					
//				}
//			});
			
			btnLess = new JButton("-");
//			btnLess.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					int q = Integer.parseInt(txtCap.getText().toString());
//					q--;
//					txtCap.setText(q+"");
//					
//				}
//			});
			btnMore2 = new JButton("+");
//			btnMore2.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					double q = Double.parseDouble(txtPrice.getText().toString());
//					q+=5;
//					txtPrice.setText(q+"");
//					AdminCinemas.table.setValueAt(q+"", num, 2);
//					AdminCinemas.cin.updateCinemas(AdminCinemas.table);
//					AdminCinemas.cin.updateTable();
////					Reservation.c.getSeats();
//				}
//			});
			
			btnLess2 = new JButton("-");
////			btnLess2.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					double q = Double.parseDouble(txtPrice.getText().toString());
//					q-=5;
//					txtPrice.setText(q+"");
//					AdminCinemas.table.setValueAt(q+"", num, 2);
//					AdminCinemas.cin.updateCinemas(AdminCinemas.table);
//					AdminCinemas.cin.updateTable();
////					Reservation.c.getSeats();
//					
//				}
//			});
			
			
			setLayout(null);
//			add(lblCinNum).setBounds(10,10,100,40);
			add(lblTitle).setBounds(10,60,80,40);
			add(txtTitle).setBounds(20,110,150,40);
			add(lblImg).setBounds(180,50,120,180);
			add(lblPrice).setBounds(320,60,80,40);
			add(txtPrice).setBounds(400,60,100,40);
			add(btnMore2).setBounds(400,100,50,20);
			add(btnLess2).setBounds(450,100,50,20);
			add(lblCap).setBounds(320,130,80,40);
			add(txtCap).setBounds(400,130,100,40);
			add(btnMore).setBounds(400,170,50,20);
			add(btnLess).setBounds(450,170,50,20);
			add(btnEdit).setBounds(700,50,200,50);
			add(btnAct).setBounds(700,100,200,50);
		}
		
		
		
	}
	void setMovId(int num){
		movID = num;
		icon = new ImageIcon(AdminMovies.table.getValueAt(movID-1, 6).toString());
		w = icon.getImage().getScaledInstance(180, 250, Image.SCALE_DEFAULT);
		lblImg.setIcon(new ImageIcon(w));
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
