package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.InitialMenuUIController;
import controller.LoginUIController;
import controller.LoginUIMouseController;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblEmail, lblPassword, lblImmigration, lblLogin;
	private JTextField tfEmail;
	private JPasswordField pfPassword;
	private JButton btnCancel, btnLogin;
	private Font font, font2;
	private JPanel panelHeader, panelForm, panelButtons;
	
	private LoginUIController loginUIController;
	
	private BufferedReader br;
	
	public LoginUI(LoginUIController loginUIController) {
		this.loginUIController = loginUIController;
		setup();
		initComponents();
		addComponentsToFrame();
		setEvents();
		
		this.setVisible(true);
		
	}
	
	private void setup() {
		this.setTitle("Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 300);
		this.setLayout(new GridLayout(3, 1));
		this.setLocationRelativeTo(null);
	}
	
	private void initComponents() {
		lblEmail = new JLabel("Email");
		tfEmail = new JTextField(20);
		lblImmigration = new JLabel("Immigration Queue System Application");
		lblLogin = new JLabel("Login");
		lblPassword = new JLabel("Password");
		pfPassword = new JPasswordField(10);
		btnCancel = new JButton("Cancel");
		btnLogin = new JButton("Login");
		
		font = new Font(Font.SANS_SERIF.toUpperCase(), Font.PLAIN, 20);
		font2 = new Font(Font.SANS_SERIF.toUpperCase(), Font.PLAIN, 25);
		lblLogin.setFont(font);
		lblEmail.setFont(font);
		tfEmail.setFont(font2);
		lblPassword.setFont(font);
		lblImmigration.setFont(font);
		
		panelHeader = new JPanel(new GridLayout(2, 1));
		panelForm = new JPanel(new GridLayout(2, 2));
		panelButtons = new JPanel();
		
		lblImmigration.setForeground(Color.WHITE);
		lblLogin.setForeground(Color.WHITE);
		lblEmail.setForeground(Color.WHITE);
		lblPassword.setForeground(Color.WHITE);
		panelHeader.setBackground(Color.BLACK);
		panelForm.setBackground(Color.BLACK);
		panelButtons.setBackground(Color.BLACK);
		
		tfEmail.setForeground(Color.WHITE);
		tfEmail.setBackground(Color.BLACK);
		
		pfPassword.setForeground(Color.WHITE);
		pfPassword.setBackground(Color.BLACK);
		
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setForeground(Color.WHITE);
		
		try {
			br = new BufferedReader(new FileReader("files/admin.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void addComponentsToFrame() {
		panelHeader.add(lblImmigration);
		panelHeader.add(lblLogin);
		panelForm.add(lblEmail);
		panelForm.add(tfEmail);
		panelForm.add(lblPassword);
		panelForm.add(pfPassword);
		panelButtons.add(btnCancel);
		panelButtons.add(btnLogin);
		
		this.add(panelHeader);
		this.add(panelForm);
		this.add(panelButtons);
	}
	
	private void setEvents() {
		
		btnCancel.addActionListener(loginUIController);
		btnCancel.setActionCommand("btnCancel-LoginUI");
		btnCancel.addMouseListener(new LoginUIMouseController(this));
	
		btnLogin.setActionCommand("btnLogin-LoginUI");
		btnLogin.addMouseListener(new LoginUIMouseController(this));
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String emailFromFile, passwordFromFile, emailGiven;
				char[] passwordGiven;
				
				try {
					// getting data from txt file
					br = new BufferedReader(new FileReader("files/admin.txt"));
					
					// reading lines of file
					emailFromFile = br.readLine();
					passwordFromFile = br.readLine();
					
					// getting info from user
					emailGiven = getTfEmail().getText();
					passwordGiven = getPfPassword().getPassword();
					
					// comparing information if is the same
					if(emailGiven.equals(emailFromFile) && String.valueOf(passwordGiven).equals(passwordFromFile)) {
						hideLoginForm();
						new InitialMenuUIController();
					} else {
						JOptionPane.showMessageDialog(null, "Acccess denied!", "Denied", JOptionPane.WARNING_MESSAGE);
						System.out.println("denied!");
						getTfEmail().setText("");
						getPfPassword().setText("");
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}

			private void hideLoginForm() {
				setVisible(false);
				
			}
		});
	}	
	
	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JPasswordField getPfPassword() {
		return pfPassword;
	}

	public void setPfPassword(JPasswordField pfPassword) {
		this.pfPassword = pfPassword;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public BufferedReader getBr() {
		return br;
	}

}
