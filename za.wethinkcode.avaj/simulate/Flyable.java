package za.wethinkcode.avaj.simulate;

import simulate.*;
import simulate.weather.*;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower WeatherTower);
}