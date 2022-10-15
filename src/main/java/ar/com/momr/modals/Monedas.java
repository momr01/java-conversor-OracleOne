package ar.com.momr.modals;

import javax.swing.JOptionPane;

import ar.com.momr.reglas.ReglasConversion;

public class Monedas {
	private String resultado;

	public Monedas() {
		this.resultado = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion de conversion", "Monedas",
				JOptionPane.PLAIN_MESSAGE, null, ReglasConversion.options, ReglasConversion.options[0]);

	}

	public String getResultado() {
		return resultado;
	}

}
