package avaj;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower = new WeatherTower();

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		switch (weather) {
		case "SUN":
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
			this.coordinates.setHeight(this.coordinates.getHeight() + 4);
			Logger.getLogger().logToFile("Baloon#" + this.name + "(" + this.id + "): This is hot");
			break;
		case "RAIN":
			this.coordinates.setHeight(this.coordinates.getHeight() - 5);
			Logger.getLogger().logToFile("Baloon#" + this.name + "(" + this.id
					+ "): I should have checked the weather this morning. Curse you rain!!");
			break;
		case "FOG":
			this.coordinates.setHeight(this.coordinates.getHeight() - 2);
			Logger.getLogger().logToFile("Baloon#" + this.name + "(" + this.id + "): This fog is too thick.");
			break;
		case "SNOW":
			this.coordinates.setHeight(this.coordinates.getHeight() - 15);
			Logger.getLogger().logToFile("Baloon#" + this.name + "(" + this.id + "): Snow! Winter is coming!!!");
			break;
		default:
			Logger.getLogger()
					.logToFile("Baloon#" + this.name + "(" + this.id + "): Unable to reach the weather tower.");
			break;
		}
		if (this.coordinates.getHeight() <= 0) {
			Logger.getLogger().logToFile("Baloon#" + this.name + "(" + this.id + ") landing.");
			Logger.getLogger().logToFile(
					"Tower  says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		weatherTower = new WeatherTower();
		Logger.getLogger()
				.logToFile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
		weatherTower.register(this);
	}

}