package ar.com.momr.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ApiExchange {
	private String api_url;
	private String api_key;
	private HttpURLConnection httpURLConnection;
	public static String response;

	public ApiExchange(String api_url, String api_key) {
		this.api_url = api_url;
		this.api_key = api_key;
	}

	public int startConnection() {
		/**
		 * https://openexchangerates.org/api/latest.json?app_id=287bc7d06c1a4e1e84e73d1362c6c120
		 * 287bc7d06c1a4e1e84e73d1362c6c120
		 */
		String GET_URL = this.api_url + this.api_key;
		URL url;
		try {
			url = new URL(GET_URL);
			this.httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			int responseCode = httpURLConnection.getResponseCode();

			return responseCode;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}

	}

	public String obtenerDatos() {
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(this.httpURLConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);

			}
			in.close();
			this.response = response.toString();
			return response.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}

	}

	public static String cotizar(String monedaFrom, String monedaTo, double importe) {
		JSONObject obj = new JSONObject(response.toString());

		double rateARS = obj.getJSONObject("rates").getDouble("ARS");
		double exchangeRate;
		String valorFinal = "";

		if (monedaFrom.equalsIgnoreCase("ARS")) {
			exchangeRate = obj.getJSONObject("rates").getDouble(monedaTo);

			double fromARStoUSD = importe / rateARS;
			double fromUSDtoOther = fromARStoUSD * exchangeRate;

			valorFinal = String.format("%,.2f", fromUSDtoOther);

		} else {
			exchangeRate = obj.getJSONObject("rates").getDouble(monedaFrom);

			double fromOthertoUSD = importe / exchangeRate;
			double fromUSDtoARS = fromOthertoUSD * rateARS;

			valorFinal = String.format("%,.2f", fromUSDtoARS);
		}

		String resultado = String.format("RESULTADO= %s %s, son %s %s.", importe, monedaFrom, valorFinal, monedaTo);

		return resultado;

	}

}
