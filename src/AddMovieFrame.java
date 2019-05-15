import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import sun.security.provider.VerificationProvider;

//import Practice.gfhf;

public class AddMovieFrame extends JFrame implements ActionListener{
	JLabel lblTitle,lblSyn,lblRat,lblDur,lblGen,lblImgSrc,lblImg;
	JTextField txtTitle,txtRat,txtDur,txtGen,txtImgSrc;
	JTextArea txtSyn;
	JFileChooser fc;
	JButton btnOpen, btnSave, btnAdd, btnCancel, btnEdit;
	JPanel filePanel;
	ImageIcon icon;
	Image w;
	JTable table;
	int row;
	Movies mov = new Movies();
	TitledBorder brd;
	AddMovieFrame() {
		lblTitle = new JLabel("Title");
		lblSyn = new JLabel("Synopsis");
		lblRat = new JLabel("Rating");
		lblDur = new JLabel("Duration");
		lblGen = new JLabel("Genre");
		lblImgSrc = new JLabel("Poster");
		brd = new TitledBorder("");
		
		txtTitle = new JTextField();		
		txtRat = new JTextField();
		txtDur = new JTextField();
		txtGen = new JTextField();
		txtImgSrc = new JTextField();
		txtImgSrc.setText("Images/none.png");
		txtImgSrc.setEditable(false);
		txtSyn = new JTextArea();
		txtSyn.setLineWrap(true);
		txtSyn.setWrapStyleWord(true);
		icon = new ImageIcon("Images/none.png");
		w = icon.getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT);
		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(w));
		lblImg.setBorder(brd);
		
		btnOpen  = new JButton("Open a File...");
		btnOpen.addActionListener(this);
		btnSave  = new JButton("Save a File...");
		btnSave.addActionListener(this);
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		fc = new JFileChooser();
		
		
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(btnOpen);
//        buttonPanel.add(btnSave);

        filePanel = new JPanel();
        filePanel.add(buttonPanel);
		
		setSize(1000,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setVisible(true);
		
		add(lblTitle).setBounds(10,10,60,30);
		add(txtTitle).setBounds(70,10,100,30);
		add(lblRat).setBounds(10,60,60,30);
		add(txtRat).setBounds(70,60,100,30);
		add(lblDur).setBounds(10,110,60,30);
		add(txtDur).setBounds(70,110,100,30);
		add(lblGen).setBounds(10,160,60,30);
		add(txtGen).setBounds(70,160,100,30);
		add(lblImgSrc).setBounds(10,210,60,30);
		add(txtImgSrc).setBounds(70,210,100,30);
		add(lblSyn).setBounds(10,310,60,30);
		add(txtSyn).setBounds(10,360,300,150);
		add(filePanel).setBounds(500,420,300,60);
		add(lblImg).setBounds(550,10,200,400);
		add(btnAdd).setBounds(400,520,100,40);
		add(btnCancel).setBounds(500,520,100,40);
		
	}
	AddMovieFrame(int row) {
		this.row = row;
		lblTitle = new JLabel("Title");
		lblSyn = new JLabel("Synopsis");
		lblRat = new JLabel("Rating");
		lblDur = new JLabel("Duration");
		lblGen = new JLabel("Genre");
		lblImgSrc = new JLabel("Poster");
		
		
		txtTitle = new JTextField();
		txtTitle.setText(AdminMovies.table.getValueAt(row, 1)+"");
		txtRat = new JTextField();
		txtRat.setText(AdminMovies.table.getValueAt(row, 3)+"");
		txtDur = new JTextField();
		txtDur.setText(AdminMovies.table.getValueAt(row, 4)+"");
		txtGen = new JTextField();
		txtGen.setText(AdminMovies.table.getValueAt(row, 5)+"");
		txtImgSrc = new JTextField();
		txtImgSrc.setText(AdminMovies.table.getValueAt(row, 6)+"");
		txtImgSrc.setEditable(false);
		txtSyn = new JTextArea();
		txtSyn.setText(AdminMovies.table.getValueAt(row, 2)+"");
		txtSyn.setLineWrap(true);
		txtSyn.setWrapStyleWord(true);
		icon = new ImageIcon(txtImgSrc.getText());
		w = icon.getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT);
		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(w));
		lblImg.setBorder(brd);
		
		btnOpen  = new JButton("Open a File...");
		btnOpen.addActionListener(this);
		btnSave  = new JButton("Save a File...");
		btnSave.addActionListener(this);
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(this);
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		fc = new JFileChooser();
		
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(btnOpen);
       // buttonPanel.add(btnSave);

        filePanel = new JPanel();
        filePanel.add(buttonPanel);
		
		setSize(1000,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setVisible(true);
		
		add(lblTitle).setBounds(10,10,60,30);
		add(txtTitle).setBounds(70,10,100,30);
		add(lblRat).setBounds(10,60,60,30);
		add(txtRat).setBounds(70,60,100,30);
		add(lblDur).setBounds(10,110,60,30);
		add(txtDur).setBounds(70,110,100,30);
		add(lblGen).setBounds(10,160,60,30);
		add(txtGen).setBounds(70,160,100,30);
		add(lblImgSrc).setBounds(10,210,60,30);
		add(txtImgSrc).setBounds(70,210,100,30);
		add(lblSyn).setBounds(10,310,60,30);
		add(txtSyn).setBounds(10,360,300,150);
		add(filePanel).setBounds(500,420,300,60);
		add(lblImg).setBounds(550,10,200,400);
		add(btnEdit).setBounds(400,520,100,40);
		add(btnCancel).setBounds(500,520,100,40);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource().equals(btnOpen)) {
	            int returnVal = fc.showOpenDialog(AddMovieFrame.this);

	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fc.getSelectedFile();
	                String name = file.getAbsolutePath();
	                icon = new ImageIcon(name);
	        		w = icon.getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT);
//	        		lblImg = new JLabel("");
	        		lblImg.setIcon(new ImageIcon(w)); 
	        		txtImgSrc.setText(name);
	            } ;

	        //Handle save button action.
	        } else if (e.getSource().equals(btnSave)) {
	            int returnVal = fc.showSaveDialog(AddMovieFrame.this);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fc.getSelectedFile();
	                String name = file.getAbsolutePath();
	                txtImgSrc.setText(name);
	                String record="";
		        	int q = AdminMovies.mov.getRecordCount();
		        	record = q+"|"+txtTitle.getText()+"|"+txtSyn.getText()+"|"+txtRat.getText()+"|"+txtDur.getText()+"|"+txtGen.getText()+"|"+txtImgSrc.getText()+"\n";
		        	mov.addMovie(record);
		        	JOptionPane.showMessageDialog(null,"Movie Added");
		        	AdminMovies.mov.updateTable();
		        	AdminMovies.table.setModel(AdminMovies.mov.mdl);
		        	
		        	AdminMenu.mov.updateMovies();
		        	dispose();
	            }
	        }else if(e.getSource().equals(btnAdd)){
	        	if(isFilledUp()==true){
	        		JOptionPane.showMessageDialog(null, AdminMovies.mov.getRecordCount());
		        	AdminMovies.mov.addMovie(getVector());
		        	JOptionPane.showMessageDialog(null,"Movie Added");
		        	AdminMovies.mov.updateTable();
		        	AdminMovies.table.setModel(AdminMovies.mov.mdl);
		        	AdminMenu.mov.updateMovies();
		        	dispose();
	        	}else{
	        		JOptionPane.showMessageDialog(null, "Please fill up all the information needed");
	        	}
	        	
	        }else if(e.getSource().equals(btnEdit)){
	        	AdminMovies.table.setValueAt(txtTitle.getText(), row, 1);
	        	AdminMovies.table.setValueAt(txtSyn.getText(), row, 2);
	        	AdminMovies.table.setValueAt(txtRat.getText(), row, 3);
	        	AdminMovies.table.setValueAt(txtDur.getText(), row, 4);
	        	AdminMovies.table.setValueAt(txtGen.getText(), row, 5);
	        	AdminMovies.table.setValueAt(txtImgSrc.getText(), row, 6);
	        	AdminMovies.mov.updateMovies(AdminMovies.table);
	        	JOptionPane.showMessageDialog(null, "Movie Edited");
	        	AdminMovies.mov.updateTable();
	        	AdminMenu.mov.updateMovies();
	        	dispose();
	        	
	        }else if(e.getSource().equals(btnCancel)){
	        	dispose();
	        }
		
	}
	String getVector(){
		String hold ="";
		hold = AdminMovies.mov.getRecordCount()+"|"+txtTitle.getText()+"|"+txtSyn.getText()+"|"+txtRat.getText()+"|"+txtDur.getText()+"|"+txtGen.getText()+"|"+txtImgSrc.getText()+"|\n";
		return hold;
	}
	boolean isFilledUp(){
		boolean otin = true;
		if(txtTitle.getText().equals("")){
			otin = false;
		}
		if(txtRat.getText().equals("")){
			otin = false;
		}
		if(txtDur.getText().equals("")){
			otin = false;
		}
		if(txtGen.getText().equals("")){
			otin = false;
		}
		if(txtSyn.getText().equals("")){
			otin = false;
		}
		return otin;
	}
}
