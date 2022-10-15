package ar.com.momr.reglas;

import java.util.ArrayList;

public class ReglasConversion {
	public static String[] options = { "De Pesos a Dolar", "De Pesos a Euros", "De Pesos a Libras Esterlinas",
			"De Pesos a Yen Japones", "De Pesos a Won surcoreano", "De Dolar a Pesos", "De Euros a Pesos",
			"De Libras Esterlinas a Pesos", "De Yen Japones a Pesos", "De Won surcoreano a Pesos" };

	public static ArrayList<String> nombresMonedas(String opcion) {
		ArrayList<String> result = new ArrayList<>();
		if (opcion.equalsIgnoreCase(options[0])) {
			result.add("ARS");
			result.add("USD");
		} else if (opcion.equalsIgnoreCase(options[1])) {
			result.add("ARS");
			result.add("EUR");
		} else if (opcion.equalsIgnoreCase(options[2])) {
			result.add("ARS");
			result.add("GBP");
		} else if (opcion.equalsIgnoreCase(options[3])) {
			result.add("ARS");
			result.add("JPY");
		} else if (opcion.equalsIgnoreCase(options[4])) {
			result.add("ARS");
			result.add("KRW");
		} else if (opcion.equalsIgnoreCase(options[5])) {
			result.add("USD");
			result.add("ARS");
		} else if (opcion.equalsIgnoreCase(options[6])) {
			result.add("EUR");
			result.add("ARS");
		} else if (opcion.equalsIgnoreCase(options[7])) {
			result.add("GBP");
			result.add("ARS");
		} else if (opcion.equalsIgnoreCase(options[8])) {
			result.add("JPY");
			result.add("ARS");
		} else if (opcion.equalsIgnoreCase(options[9])) {
			result.add("KRW");
			result.add("ARS");
		}
		return result;
	}

}
