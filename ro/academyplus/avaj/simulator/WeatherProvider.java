package ro.academyplus.avaj.simulator;

public class WeatherProvider {

    private WeatherProvider weatherProvider;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public WeatherProvider() {

    int rand = (int )(Math.random() * 4);
    String[][] arrays = new String[5][];
	int i = 0;
    while (i < 100)
    {
        arrays[i] = new String[] {"a", weather[rand], weather[rand]};
        i++;
    }
	
    }
    public WeatherProvider getProvider() {
        
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates) {
	
        //return allWeather[coordinates.getLongitude()][coordinates.getLatitude()][coordinates.getHeight()];
	return "test";
    }

}
