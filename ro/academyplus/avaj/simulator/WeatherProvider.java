package ro.academyplus.avaj.simulator;

public class WeatherProvider {

    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    // SINGLETON:
    // http://thecodersbreakfast.net/index.php?post/2008/02/25/26-de-la-bonne-implementation-du-singleton-en-java

    // Factory design pattern:
    // https://www.journaldev.com/1392/factory-design-pattern-in-java

    /** C'est un Constructeur privé car c'est un Singleton et qu'il n'y aura qu'une instance: */
    private WeatherProvider() {
    
    }
    
    /** Instance unique pré-initialisée */
    private static WeatherProvider weatherProvider = new WeatherProvider();
     
    /** Point d'accès pour l'instance unique du singleton */
    public static WeatherProvider getProvider() {

        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
    
        int rand = (int )((Math.random() * (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight())) % 4);
	    return weather[rand];
    }

}
