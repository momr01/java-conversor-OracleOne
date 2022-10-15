package ar.com.momr.modals;

import javax.swing.JOptionPane;

public class SelectAnOption {

	private Integer opcion;

	public SelectAnOption() {
		this.opcion = JOptionPane.showConfirmDialog(null, "Deseas continuar?", "Mensaje",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
	}

	public Integer getOpcion() {
		return opcion;
	}
}
