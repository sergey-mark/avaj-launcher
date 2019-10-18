package ro.academyplus.avaj.simulator;

public class                Helicopter extends Aircraft implements Flyable {

    private WeatherTower    weatherTower;

    public Helicopter(String name, Coordinates coordinates) {

		System.out.println("Call of class Helicopter.");
		super(name, coordinates); //super() permet d'appeler le contructeur parent
		updateConditions();
    }

	public void updateConditions() {	
		System.out.println("updateConditions from Baloon !!!");
		if (weatherTower.getWeather(super.coordinates) == "SUN")
		{
			super.coordinates.lontitude += 10;
			super.coordinates.height += 2;
		}
		else if (weatherTower.getWeather(super.coordinates) == "RAIN")
			super.coordinates.lontitude += 5;
		else if (weatherTower.getWeather(super.coordinates) == "FOG")
			super.coordinates.lontitude += 1;
		else if (weatherTower.getWeather(super.coordinates) == "SNOW") {
			if (super.coordinates.height >= 12)
				super.coordinates.height -= 12;
			else
				super.coordinates.height = 0;
		}
	}
    public void registerTower(WeatherTower weatherTower) {
		System.out.println("registerTower from Baloon !!!");
	}

}
