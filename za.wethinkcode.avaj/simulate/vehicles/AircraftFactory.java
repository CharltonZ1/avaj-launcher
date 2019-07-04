package simulate.vehicles;

import weather.Coordinates;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (type == null) {
            return null;
        }

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.equalsIgnoreCase("JetPlane")) {
            return new JetPlane(name, coordinates);
        }
    }
}