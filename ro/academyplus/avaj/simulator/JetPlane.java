package ro.academyplus.avaj.simulator;

public class                JetPlane extends Aircraft implements Flyable {

    private WeatherTower    weatherTower;

    public JetPlane(String name, Coordinates coordinates) {

		System.out.println("Call of class JetPlane.");
		super(name, coordinates); //super() permet d'appeler le contructeur parent
		updateConditions();
    }

	public void updateConditions() {	
		//System.out.println("updateConditions from Baloon !!!");
		if (weatherTower.getWeather(super.coordinates) == "SUN")
		{
			super.coordinates.latitude = (super.coordinates.latitude + 10 > 100) ? 100 : super.coordinates.latitude + 10;
			super.coordinates.height = (super.coordinates.height + 2 > 100) ? 100 : super.coordinates.height + 2;
		}
		else if (weatherTower.getWeather(super.coordinates) == "RAIN")
			super.coordinates.latitude = (super.coordinates.latitude + 5 > 100) ? 100 : super.coordinates.latitude + 5;
		else if (weatherTower.getWeather(super.coordinates) == "FOG")
			super.coordinates.latitude = (super.coordinates.latitude + 1 > 100) ? 100 : super.coordinates.latitude + 1;
		else if (weatherTower.getWeather(super.coordinates) == "SNOW") {
			super.coordinates.height = (super.coordinates.height >= 7) ? super.coordinates.height - 7 : 0;
		}
		System.out.println("JetPlane" + "#" + super.name + "(" + super.id + "): Let's enjoy the good weather and take some pics.");
		if (super.coordinates.height == 0) //If an aircraft reaches height 0 or needs to go below unregisters from the weather tower
			weatherTower.unregister(super);
		
	}
    	public void registerTower(WeatherTower weatherTower) {
		
		System.out.println("registerTower from Baloon !!!");
		weatherTower.register(this);
		System.out.println("Tower says: " + "JetPlane" + "#" + super.name + "(" + super.id + ") registered from weather tower.");
	}

}
