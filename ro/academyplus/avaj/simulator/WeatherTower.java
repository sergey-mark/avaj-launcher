package ro.academyplus.avaj.simulator;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        
        WeatherProvider tmp = WeatherProvider.getProvider( ); // To get singleton
        return tmp.getCurrentWeather( coordinates );
    }

    public void changeWeather() {

        this.conditionsChanged();
    }
}
