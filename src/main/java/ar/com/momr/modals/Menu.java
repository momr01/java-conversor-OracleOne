package ar.com.momr.modals;

import javax.swing.JOptionPane;

public class Menu {

	private String[] options = { "Conversor de Moneda", "Mas proximamente" };

	public Menu() {

	}

	public String[] getOptions() {
		return options;
	}

	public String runModal() {
		return (String) JOptionPane.showInputDialog(null, "Seleccione una opcion de conversion", "Menu",
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}
}
