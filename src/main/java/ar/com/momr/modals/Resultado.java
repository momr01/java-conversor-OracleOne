package ar.com.momr.modals;

import javax.swing.JOptionPane;

public class Resultado {

	private int opcion;

	public Resultado(String rta) {
		this.opcion = JOptionPane.showConfirmDialog(null, rta, "Mensaje", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE);

	}

	public Integer getOpcion() {
		return opcion;
	}

}
