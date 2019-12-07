package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.PersonTableUI;

public class PersonTableUIMouseController implements MouseListener {
	
	private PersonTableUI personTableUI;
	
	public PersonTableUIMouseController(PersonTableUI personTableUI) {
		this.personTableUI = personTableUI;
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
		
		if(e.getSource().equals(personTableUI.getBtnAdd())) {
			personTableUI.getBtnAdd().setForeground(Color.CYAN);
			personTableUI.getBtnAdd().setSize(personTableUI.getBtnAdd().getWidth() + 10, personTableUI.getBtnAdd().getHeight() + 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnBack())) {
			personTableUI.getBtnBack().setForeground(Color.CYAN);
			personTableUI.getBtnBack().setSize(personTableUI.getBtnBack().getWidth() + 10, personTableUI.getBtnBack().getHeight() + 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnCallNext())) {
			personTableUI.getBtnCallNext().setForeground(Color.CYAN);
			personTableUI.getBtnCallNext().setSize(personTableUI.getBtnCallNext().getWidth() + 10, personTableUI.getBtnCallNext().getHeight() + 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnDelete())) {
			personTableUI.getBtnDelete().setForeground(Color.CYAN);
			personTableUI.getBtnDelete().setSize(personTableUI.getBtnDelete().getWidth() + 10, personTableUI.getBtnDelete().getHeight() + 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnDeleteNpersons())) {
			personTableUI.getBtnDeleteNpersons().setForeground(Color.CYAN);
			personTableUI.getBtnDeleteNpersons().setSize(personTableUI.getBtnDeleteNpersons().getWidth() + 10, personTableUI.getBtnDeleteNpersons().getHeight() + 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnUpdate())) {
			personTableUI.getBtnUpdate().setForeground(Color.CYAN);
			personTableUI.getBtnUpdate().setSize(personTableUI.getBtnUpdate().getWidth() + 10, personTableUI.getBtnUpdate().getHeight() + 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnFindById())) {
			personTableUI.getBtnFindById().setForeground(Color.CYAN);
			personTableUI.getBtnFindById().setSize(personTableUI.getBtnFindById().getWidth() + 10, personTableUI.getBtnFindById().getHeight() + 10);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(personTableUI.getBtnAdd())) {
			personTableUI.getBtnAdd().setForeground(Color.WHITE);
			personTableUI.getBtnAdd().setSize(personTableUI.getBtnAdd().getWidth() - 10, personTableUI.getBtnAdd().getHeight() - 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnBack())) {
			personTableUI.getBtnBack().setForeground(Color.WHITE);
			personTableUI.getBtnBack().setSize(personTableUI.getBtnBack().getWidth() - 10, personTableUI.getBtnBack().getHeight() - 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnCallNext())) {
			personTableUI.getBtnCallNext().setForeground(Color.WHITE);
			personTableUI.getBtnCallNext().setSize(personTableUI.getBtnCallNext().getWidth() - 10, personTableUI.getBtnCallNext().getHeight() - 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnDelete())) {
			personTableUI.getBtnDelete().setForeground(Color.WHITE);
			personTableUI.getBtnDelete().setSize(personTableUI.getBtnDelete().getWidth() - 10, personTableUI.getBtnDelete().getHeight() - 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnDeleteNpersons())) {
			personTableUI.getBtnDeleteNpersons().setForeground(Color.WHITE);
			personTableUI.getBtnDeleteNpersons().setSize(personTableUI.getBtnDeleteNpersons().getWidth() - 10, personTableUI.getBtnDeleteNpersons().getHeight() - 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnUpdate())) {
			personTableUI.getBtnUpdate().setForeground(Color.WHITE);
			personTableUI.getBtnUpdate().setSize(personTableUI.getBtnUpdate().getWidth() - 10, personTableUI.getBtnUpdate().getHeight() - 10);
		}
		
		if(e.getSource().equals(personTableUI.getBtnFindById())) {
			personTableUI.getBtnFindById().setForeground(Color.WHITE);
			personTableUI.getBtnFindById().setSize(personTableUI.getBtnFindById().getWidth() - 10, personTableUI.getBtnFindById().getHeight() - 10);
		}
		
	}

}
