package Weather;

import java.util.Random;

public class WeatherProvider {

	 private static WeatherProvider weatherProvider;
	    private String [] weather = {"RAIN", "FOG", "SUN", "SNOW"};
	    Random rand = new Random();
	    int rando = rand.nextInt(4);

	    private  WeatherProvider()
	    {

	    }

	    public static WeatherProvider getProvider()
	    {
	        return weatherProvider;
	    }
	    
	    public String getCurrentWeather(Coordinates coordinates)
	    {
	        return (weather[rando]);
	    }
}
