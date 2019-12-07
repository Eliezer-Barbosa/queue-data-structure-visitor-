package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginUIController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("btnCancel-LoginUI")) {
			JOptionPane.showMessageDialog(null, "Turning off...", "Shut down", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}

	}//action

}//class


