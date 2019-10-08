package ro.academyplus.avaj.simulator;

public class WeatherProvider {

    private WeatherProvider weatherProvider;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public void WeatherProvider() {

	/*int n = rand(0, 4);
	int i = 0;
	while (i < )
	private String[][][] allWeather = weather[n];*/
    }
    public WeatherProvider getProvider() {
        
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates) {
	
        //return allWeather[coordinates.getLongitude()][coordinates.getLatitude()][coordinates.getHeight()];
	return "test";
    }

}
