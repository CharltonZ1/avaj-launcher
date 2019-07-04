package aircraft;
import Weather.Coordinates;

public class Aircrafts {
	
	 protected long _id;
	    protected String _name;
	    protected Coordinates _coordinates;
	    private static long idCounter = 1;

	    protected Aircrafts(String name, Coordinates coordinates) {
	        _name = name;
	        _coordinates = coordinates;
	        _id = nextId();
	    }

	    private long nextId() {
	        return idCounter++;
	    }

}
