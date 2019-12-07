package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.LoginUI;

public class LoginUIMouseController implements MouseListener {
	
	private LoginUI loginUI;
	
	public LoginUIMouseController(LoginUI loginUI) {
		this.loginUI = loginUI;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(loginUI.getBtnCancel())) {
			loginUI.getBtnCancel().setBackground(new Color(185, 9, 12));
			loginUI.getBtnCancel().setForeground(Color.white);
			loginUI.getBtnCancel().setSize(loginUI.getBtnCancel().getWidth() + 5, loginUI.getBtnCancel().getHeight() + 5);
		} 
		
		if(e.getSource().equals(loginUI.getBtnLogin())) {
			loginUI.getBtnLogin().setBackground(new Color(51,124,153));
			loginUI.getBtnLogin().setForeground(Color.white);
			loginUI.getBtnLogin().setSize(loginUI.getBtnLogin().getWidth() + 5, loginUI.getBtnLogin().getHeight() + 5);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(loginUI.getBtnCancel())) {
			loginUI.getBtnCancel().setBackground(Color.BLACK);
			loginUI.getBtnCancel().setForeground(Color.WHITE);
			loginUI.getBtnCancel().setSize(loginUI.getBtnCancel().getWidth() - 5, loginUI.getBtnCancel().getHeight() - 5);
		}
		
		if(e.getSource().equals(loginUI.getBtnLogin())) {
			loginUI.getBtnLogin().setBackground(Color.BLACK);
			loginUI.getBtnLogin().setForeground(Color.WHITE);
			loginUI.getBtnLogin().setSize(loginUI.getBtnLogin().getWidth() - 5, loginUI.getBtnLogin().getHeight() - 5);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
