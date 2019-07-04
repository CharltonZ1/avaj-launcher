import simulate.vehicles.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[]        weather = {
        "SUN",
        "RAIN",
        "SNOW",
        "FOG"
    };

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public static String getCurrentWeather(Coordinates coordinates) {
        if (coordinates) {
            int longitude = coordinates.getLongitude();
            int latitude = coordinates.getLatitude();
            int height = coordinates.getHeight();

            int weatherIndex = (longitude + latitude + height) % 4;
            return (weather[weatherIndex]);
        }
    }
}