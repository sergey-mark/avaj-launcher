public class WeatherProvider {

    private WeatherProvider weatherProvider;
    private String[] weather = "default weather";

    public void WeatherProvider() {

    }
    public WeatherProvider getProvider() {
        String weather = "test SUN weatherTower";
        return weather;
    }
    public String getCurrentWeather(Coordinates coordinates) {
        return weather;
    }

}
