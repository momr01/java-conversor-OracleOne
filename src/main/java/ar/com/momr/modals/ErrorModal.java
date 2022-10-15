package ar.com.momr.modals;

import javax.swing.JOptionPane;

public class ErrorModal {

	private Integer resultado;

	public ErrorModal(String mensaje) {
		this.resultado = JOptionPane.showConfirmDialog(null, mensaje, "Error!", JOptionPane.DEFAULT_OPTION,
				JOptionPane.ERROR_MESSAGE);
	}

	public Integer getResultado() {
		return resultado;
	}
}
