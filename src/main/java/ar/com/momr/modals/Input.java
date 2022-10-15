package ar.com.momr.modals;

import javax.swing.JOptionPane;

public class Input {

	private String resultado;

	public Input() {
		this.resultado = JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero que deseas convertir:", 0);
	}

	public String getResultado() {
		return resultado;
	}
}
