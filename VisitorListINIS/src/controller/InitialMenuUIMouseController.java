package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.InitialMenuUI;

public class InitialMenuUIMouseController implements MouseListener {
	
	private InitialMenuUI initialMenuUI;
	
	public InitialMenuUIMouseController(InitialMenuUI initialMenuUI) {
		this.initialMenuUI = initialMenuUI;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(initialMenuUI.getBtnDisplayQueue()))
			initialMenuUI.getBtnDisplayQueue().setForeground(Color.CYAN);
		if(e.getSource().equals(initialMenuUI.getBtnAddPerson()))
			initialMenuUI.getBtnAddPerson().setForeground(Color.CYAN);
		if(e.getSource().equals(initialMenuUI.getBtnDeletePerson()))
			initialMenuUI.getBtnDeletePerson().setForeground(Color.CYAN);
		if(e.getSource().equals(initialMenuUI.getBtnUpdatePerson()))
			initialMenuUI.getBtnUpdatePerson().setForeground(Color.CYAN);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(initialMenuUI.getBtnDisplayQueue()))
			initialMenuUI.getBtnDisplayQueue().setForeground(Color.WHITE);
		if(e.getSource().equals(initialMenuUI.getBtnAddPerson()))
			initialMenuUI.getBtnAddPerson().setForeground(Color.WHITE);
		if(e.getSource().equals(initialMenuUI.getBtnDeletePerson()))
			initialMenuUI.getBtnDeletePerson().setForeground(Color.WHITE);
		if(e.getSource().equals(initialMenuUI.getBtnUpdatePerson()))
			initialMenuUI.getBtnUpdatePerson().setForeground(Color.WHITE);
		
	}

}
