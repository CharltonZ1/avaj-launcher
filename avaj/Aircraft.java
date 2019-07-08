package avaj;

class Aircraft {
	protected Long id;
	protected String name;
	protected Coordinates coordinates;
	private static Long idCounter = 1L;

	protected Aircraft(String name, Coordinates coordinates) {
		this.coordinates = coordinates;
		this.name = name;
		id = idCounter;
		idCounter = nextid();
	}

	private long nextid() {
		return (idCounter++);
	}
}