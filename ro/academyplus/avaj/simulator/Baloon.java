package ro.academyplus.avaj.simulator;

public class                Baloon extends Aircraft implements Flyable { 

	private WeatherTower    weatherTower = new WeatherTower();

    public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
		System.out.println("Call of class Baloon.");
		this.registerTower(weatherTower);
		//weatherTower.getWeather(coordinates);
		//updateConditions();
	}
	
    public void updateConditions() {	
		System.out.println("updateConditions from Baloon !!!");
		weatherTower.conditionsChanged();
		System.out.println(weatherTower.getWeather(super.coordinates));
		if (weatherTower.getWeather(super.coordinates) == "SUN")
		{
			System.out.println("SUN !!!");
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 2 > 100) ? 100 : super.coordinates.getLongitude() + 2);
			super.coordinates.setHeight((super.coordinates.getHeight() + 4 > 100) ? 100 : super.coordinates.getHeight() + 4);
		}
		else if (weatherTower.getWeather(super.coordinates) == "RAIN")
			super.coordinates.setHeight((super.coordinates.getHeight() >= 5) ? super.coordinates.getHeight() - 5 : 0);
		else if (weatherTower.getWeather(super.coordinates) == "FOG")
			super.coordinates.setHeight((super.coordinates.getHeight() >= 3) ? super.coordinates.getHeight() - 3 : 0);
		else if (weatherTower.getWeather(super.coordinates) == "SNOW") {
			super.coordinates.setHeight((super.coordinates.getHeight() >= 15) ? super.coordinates.getHeight() - 15 : 0);
		}
		System.out.println("Baloon" + "#" + super.name + "(" + super.id + "): Let's enjoy the good weather and take some pics.");
		if (super.coordinates.getHeight() == 0) //If an aircraft reaches height 0 or needs to go below unregisters from the weather tower
			this.weatherTower.unregister(this);
	}
    public void registerTower(WeatherTower weatherTower) {
		
		weatherTower.register(this);
		System.out.println("Tower says: " + "Baloon" + "#" + this.name + "(" + super.id + ") registered from weather tower.");
	}
        

}
