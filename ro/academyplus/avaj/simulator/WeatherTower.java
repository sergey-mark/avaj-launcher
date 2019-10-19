package ro.academyplus.avaj.simulator;

public class WeatherTower extends Tower {

    public void changeWeather() {

    	System.out.println("Call of function changeWeather from Tower."); 
    	System.out.println("TYPE#NAME(UNIQUE_ID): SPECIFIC_MESSAGE.");
    }
    public String getWeather(Coordinates coordinates) {
        
        WeatherProvider tmp = WeatherProvider.getProvider( ); // To instanciante singleton
        return tmp.getCurrentWeather( coordinates );
    }

}
