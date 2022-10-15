package ar.com.momr.main;

import java.util.ArrayList;

import ar.com.momr.api.ApiExchange;
import ar.com.momr.modals.ErrorModal;
import ar.com.momr.modals.Input;
import ar.com.momr.modals.Menu;
import ar.com.momr.modals.Monedas;
import ar.com.momr.modals.Resultado;
import ar.com.momr.modals.SelectAnOption;
import ar.com.momr.reglas.ReglasConversion;

public class Main {
	private static int estadoConn;
	private static ApiExchange newConnection;
	private static double importe;
	private static String resultado;

	public static void main(String[] args) {
		nuevoMenu();

	}

	public static void nuevoMenu() {
		Menu menu = new Menu();
		String rta = menu.runModal();

		if (rta != null) {
			if (rta.equalsIgnoreCase("conversor de moneda")) {
				newConnection = new ApiExchange("https://openexchangerates.org/api/latest.json?app_id=",
						"287bc7d06c1a4e1e84e73d1362c6c120");
				estadoConn = newConnection.startConnection();

				if (estadoConn == 200) {
					newConnection.obtenerDatos();
					nuevoInput();
				}

				else {
					new ErrorModal("Error de conexión con la Base de Datos.");
					nuevoMenu();
				}

			} else {
				new ErrorModal("La elección no se encuentra disponible");
				nuevoMenu();
			}
		} else {
			new ErrorModal("Programa finalizado");
		}
	}

	public static void nuevoInput() {

		Input input = new Input();
		String res = input.getResultado();
		if (res == null) {
			nuevoMenu();
		} else {
			try {
				int cantidad = Integer.parseInt(res);
				if (cantidad <= 0) {
					new ErrorModal("Por favor ingrese un valor distinto de cero.");
					nuevoInput();
				} else {
					importe = Double.valueOf(cantidad);
					nuevoMonedas();
				}
			} catch (Exception e) {
				new ErrorModal("Por favor ingrese sólo números.");
				nuevoInput();
			}
		}

	}

	public static void nuevoMonedas() {
		Monedas monedas = new Monedas();
		resultado = monedas.getResultado();

		if (resultado == null) {
			nuevoInput();
		} else {
			nuevoResultado();
		}

	}

	public static void nuevoResultado() {
		ArrayList<String> res = ReglasConversion.nombresMonedas(resultado);
		String rta = newConnection.cotizar(res.get(0), res.get(1), importe);

		new Resultado(rta);
		nuevoOpcionesFinales();

	}

	public static void nuevoOpcionesFinales() {
		SelectAnOption opcFinal = new SelectAnOption();
		int eleccion = opcFinal.getOpcion();

		if (eleccion == 0) {
			importe = 0;
			resultado = "";
			nuevoMenu();
		} else if (eleccion == 1 || eleccion == -1)
			new ErrorModal("Programa finalizado");
		else if (eleccion == 2)
			nuevoResultado();

	}
}