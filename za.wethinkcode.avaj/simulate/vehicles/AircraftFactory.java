package simulate.vehicles;

import vehicles.*;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
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