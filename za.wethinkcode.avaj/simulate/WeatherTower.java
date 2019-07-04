package simulate;

import simulate.vehicles.Coordinates;

public class WeatherTower extends Tower {
    public String   getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }
}