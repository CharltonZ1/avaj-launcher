package Weather;

public class Coordinates {

	public int longitude;
	public int latitude;
	public int height;
	
	public Coordinates(int lo, int lat, int ht)
	{
		if (lo < 0)
			lo = 0;
		else if(lat < 0)
			lat = 0;
		else if(ht < 0)
			ht = 0;
		else if(ht > 100)
			ht = 100;
		
		longitude = lo;
		latitude = lat;
		height = ht;
	}
	
	public int getlo()
	{
		return longitude;
	}
	
	public int getlat()
	{
		return latitude;
	}
	
	public int getht()
	{
		return height;
	}
	
}
