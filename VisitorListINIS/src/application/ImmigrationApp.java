package application;

import controller.LoginUIController;
import view.LoginUI;

public class ImmigrationApp {
	public static void main(String[] args) {
		new LoginUI(new LoginUIController());
	}
}
