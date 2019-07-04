package simulate.weather;

import java.util.ArrayList;
import java.util.List;
import za.wethinkcode.avaj.*;
import simulate.weather.*;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if (observers.contains(flyable))
            return;
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        if (observers.contains(flyable))
            observers.remove(flyable);
        return;
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}