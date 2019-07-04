package za.wethinkcode.avaj.simulate;

import simulate.*;
import simulate.weather.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
        case "SUN":
            coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(),
                    coordinates.getHeight() + 2);
            if (this.coordinates.getHeight() > 100) {
                this.coordinates.setLongitude(100);
            }
            Logger.getLogFile().logToFile("Helicopter#" + this.name + "(" + this.id + "): This is hot");
            break;
        case "RAIN":
            coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                    coordinates.getHeight());
            Logger.getLogFile()
                    .logToFile("Helicopter#" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon");
            break;
        case "FOG":
            coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),
                    coordinates.getHeight());
            Logger.getLogFile()
                    .logToFile("Helicopter#" + this.name + "(" + this.id + "): I can't see a thing in this fog");
            break;
        case "SNOW":
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 12);
            Logger.getLogFile().logToFile("Helicopter#" + this.name + "(" + this.id + "): Snow! Winter is coming");
        default:
            Logger.getLogFile().logToFile("Helicopter#" + this.name + "(" + this.id + "): Unable to reach Tower.");
            break;
        }
        if (this.coordinates.getHeight() <= 0) {
            Logger.getLogFile().logToFile("Helicopter#" + this.name + "(" + this.id + ") landing.");
            Logger.getLogFile().logToFile(
                    "Tower  says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower = new WeatherTower();
        Logger.getLogFile()
        .logToFile("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        weatherTower.register(this);
    }
}