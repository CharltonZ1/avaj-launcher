package aircraft;

import Weather.Coordinates;
import Weather.Flyable;
import Weather.WeatherTower;

public class Helicopter extends Aircrafts implements Flyable{

	private WeatherTower weatherTower;
	protected Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateConditions() {
		// TODO Auto-generated method stub
		String weahter = weatherTower.getWeather(_coordinates);
		switch(weahter) {
		case "RAIN" :
			_coordinates = new Coordinates(_coordinates.getht() + 0, _coordinates.getlat() + 0, _coordinates.getlo() + 5);
			break;
		case "FOG" :
			_coordinates = new Coordinates(_coordinates.getht() + 0, _coordinates.getlat() + 0, _coordinates.getlo() + 1);
			break;
		case "SUN" : 
			_coordinates = new Coordinates(_coordinates.getht() + 2, _coordinates.getlat() + 0, _coordinates.getlo() + 10);
			break;
		case "SNOW" :
			_coordinates = new Coordinates(_coordinates.getht() - 12, _coordinates.getlat() + 0, _coordinates.getlo() + 0);
		}
	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		// TODO Auto-generated method stub
		weatherTower = WeatherTower;
		WeatherTower.register(this);
		
	}

}
