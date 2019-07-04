package simulate.vehicles;

import vehicles.Flyable;
import vehicles.WeatherTower;
import weather.Coordinates;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower    weatherTower;

    private Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String  weather = weatherTower.getWeather(coordinates);

        switch(weather) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower = new WeatherTower();
        weatherTower.register(this);
    }
}