package za.wethinkcode.avaj.simulate;

import simulate.*;
import simulate.weather.*;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.equalsIgnoreCase("JetPlane")) {
            return new JetPlane(name, coordinates);
        } else if (type.equalsIgnoreCase("Helicopter")) {
            return new Helicopter(name, coordinates);
        } else if (type.equalsIgnoreCase("Baloon")) {
            return (new Baloon(name, coordinates));
        } else {
            return null;
        }
    }
}