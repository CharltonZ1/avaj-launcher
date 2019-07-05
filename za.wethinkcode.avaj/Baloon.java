package za.wethinkcode.avaj;

import za.wethinkcode.avaj.*;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
        case "SUN":
            coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(),
                    coordinates.getHeight() + 4);
            if (this.coordinates.getHeight() > 100) {
                this.coordinates.setLongitude(100);
            }
            Logger.getLogFile().logToFile("Baloon#" + this.name + "(" + this.id + "): This is hot");
            break;
        case "RAIN":
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 5);
            Logger.getLogFile()
                    .logToFile("Baloon#" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon");
            break;
        case "FOG":
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 3);
            Logger.getLogFile()
                    .logToFile("Baloon#" + this.name + "(" + this.id + "): I can't see a thing in this fog");
            break;
        case "SNOW":
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 15);
            Logger.getLogFile().logToFile("Baloon#" + this.name + "(" + this.id + "): Snow! Winter is coming");
            Logger.getLogFile().logToFile(
                    "Tower  says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        default:
            Logger.getLogFile()
                    .logToFile("Baloon#" + this.name + "(" + this.id + "): I CANT CONTACT THE WEATHER TOWER");
            break;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower = new WeatherTower();
        Logger.getLogFile()
                .logToFile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        weatherTower.register(this);
    }
}