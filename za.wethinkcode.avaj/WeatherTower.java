package za.wethinkcode.avaj;

import za.wethinkcode.avaj.*;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}