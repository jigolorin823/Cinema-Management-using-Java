import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI extends JFrame{
	JPanel panel;
	JLabel lblUser, lblPass,lblTitle;
	JTextField txtUser;
	JPasswordField txtPass;
	JButton btnLogin, btnCancel;
	
	public LoginUI() {
		panel = new JPanel();
		lblTitle = new JLabel("SIHNEHMAHBEYHBEH");
		lblTitle.setFont(new Font("Courier", Font.BOLD, 20));
		lblUser = new JLabel("Username: ");
		lblPass = new JLabel("Password: ");
		txtUser = new JTextField(10);
		txtPass = new JPasswordField(10);
		btnLogin = new JButton("Login");
		btnCancel = new JButton("Cancel");
		
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		setVisible(true);
		
		panel.setLayout(null);
		panel.setSize(400,300);
		panel.add(lblTitle).setBounds(150,10,200,100);
		panel.add(lblUser).setBounds(150,120,70,40);
		panel.add(txtUser).setBounds(220,120,130,35);
		panel.add(lblPass).setBounds(150,160,70,40);
		panel.add(txtPass).setBounds(220,160,130,35);
		panel.add(btnLogin).setBounds(150,200,100,40);
		panel.add(btnCancel).setBounds(250,200,100,40);
		
		add(panel,BorderLayout.CENTER);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUser.getText().equals("jigornaut")&& new String(txtPass.getPassword()).equals("qwezxc")){
					Home.am.setVisible(true);
					Home.lg.setVisible(false);
					txtUser.setText("");
					txtPass.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Username and Password does not match");
				}
				
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.g.setVisible(true);
				Home.lg.setVisible(false);
				
			}
		});
	}
}
