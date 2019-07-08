package avaj;

import	avaj.*;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = { "SUN", "RAIN", "FOG", "SNOW" };

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		int rand_int = (longitude + latitude + height) % 4;
		return (weather[rand_int]);
	}
}