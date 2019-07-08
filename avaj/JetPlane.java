package avaj;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower = new WeatherTower();

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		switch (weather) {
		case "SUN":
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
			Logger.getLogger().logToFile("JetPlane#" + this.name + "(" + this.id + "): This is hot");
			break;
		case "RAIN":
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
			Logger.getLogger().logToFile("JetPlane#" + this.name + "(" + this.id
					+ "): I should have checked the weather this morning. Curse you rain!!");
			break;
		case "FOG":
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
			Logger.getLogger().logToFile("JetPlane#" + this.name + "(" + this.id + "): This fog is too thick.");
			break;
		case "SNOW":
			this.coordinates.setHeight(this.coordinates.getHeight() - 12);
			Logger.getLogger().logToFile("JetPlane#" + this.name + "(" + this.id + "): Snow! Winter is coming!!!");
			break;
		default:
			Logger.getLogger()
					.logToFile("JetPlane#" + this.name + "(" + this.id + "): Unable to reach the weather tower.");
			break;
		}
		if (this.coordinates.getHeight() <= 0) {
			Logger.getLogger().logToFile("JetPlane#" + this.name + "(" + this.id + ") landing.");
			Logger.getLogger().logToFile(
					"Tower  says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		weatherTower = new WeatherTower();
		Logger.getLogger()
				.logToFile("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
		weatherTower.register(this);
	}

}