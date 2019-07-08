package avaj;

class Aircraft {
	protected Long id;
	protected String name;
	protected Coordinates coordinates;
	private static Long idCounter = 1L;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		id = idCounter;
		idCounter = nextid();
	}

	private long nextid() {
		return (++idCounter);
	}
}