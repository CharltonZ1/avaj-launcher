package aircraft;

import Weather.Coordinates;
import Weather.Flyable;
import Weather.WeatherTower;

public class Baloon extends Aircrafts implements Flyable{

	WeatherTower weatherTower;
	protected Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateConditions() {
		// TODO Auto-generated method stub
		String weahter = weatherTower.getWeather(_coordinates);
		switch(weahter) {
		case "RAIN" :
			_coordinates = new Coordinates(_coordinates.getht() - 5, _coordinates.getlat() + 0, _coordinates.getlo() + 0);
			break;
		case "FOG" :
			_coordinates = new Coordinates(_coordinates.getht() - 2, _coordinates.getlat() + 0, _coordinates.getlo() + 0);
			break;
		case "SUN" : 
			_coordinates = new Coordinates(_coordinates.getht() + 4, _coordinates.getlat() + 0, _coordinates.getlo() + 2);
			break;
		case "SNOW" :
			_coordinates = new Coordinates(_coordinates.getht() - 15, _coordinates.getlat() + 0, _coordinates.getlo() + 0);
		}
	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		// TODO Auto-generated method stub
		weatherTower = WeatherTower;
		WeatherTower.register(this);
		
	}
}
