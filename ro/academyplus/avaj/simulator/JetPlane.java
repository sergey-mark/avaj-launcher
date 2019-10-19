package ro.academyplus.avaj.simulator;

public class                JetPlane extends Aircraft implements Flyable {

    private WeatherTower    weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
		System.out.println("Call of class JetPlane.");
		updateConditions();
    }

	public void updateConditions() {	
		//System.out.println("updateConditions from Baloon !!!");
		if (weatherTower.getWeather(super.coordinates) == "SUN")
		{
			super.coordinates.setLatitude((super.coordinates.getLatitude() + 10 > 100) ? 100 : super.coordinates.getLatitude() + 10);
			super.coordinates.setHeight((super.coordinates.getHeight() + 2 > 100) ? 100 : super.coordinates.getHeight() + 2);
		}
		else if (weatherTower.getWeather(super.coordinates) == "RAIN")
			super.coordinates.setLatitude((super.coordinates.getLatitude() + 5 > 100) ? 100 : super.coordinates.getLatitude() + 5);
		else if (weatherTower.getWeather(super.coordinates) == "FOG")
			super.coordinates.setLatitude((super.coordinates.getLatitude() + 1 > 100) ? 100 : super.coordinates.getLatitude() + 1);
		else if (weatherTower.getWeather(super.coordinates) == "SNOW") {
			super.coordinates.setHeight((super.coordinates.getHeight() >= 7) ? super.coordinates.getHeight() - 7 : 0);
		}
		System.out.println("JetPlane" + "#" + super.name + "(" + super.id + "): Let's enjoy the good weather and take some pics.");
		if (super.coordinates.getHeight() == 0) //If an aircraft reaches height 0 or needs to go below unregisters from the weather tower
			this.weatherTower.unregister(this);
		
	}
    	public void registerTower(WeatherTower weatherTower) {
		
		//System.out.println("registerTower from Baloon !!!");
		weatherTower.register(this);
		System.out.println("Tower says: " + "JetPlane" + "#" + super.name + "(" + super.id + ") registered from weather tower.");
	}

}
