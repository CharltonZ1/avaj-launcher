package simulate.vehicles;

import vehicles.Flyable;
import vehicles.WeatherTower;
import weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower    weatherTower;

    private Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String  weather = weatherTower.getWeather(coordinates);

        switch(weather) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower = new WeatherTower();
        weatherTower.register(this);
    }
}