package ro.academyplus.avaj.simulator;

public class                JetPlane extends Aircraft implements Flyable {

    private WeatherTower    weatherTower = new WeatherTower();

    public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
		System.out.println("Call of class JetPlane.");
		this.registerTower(weatherTower);
		//updateConditions();
    }

	public void updateConditions() {	
		//System.out.println("updateConditions from Baloon !!!");
		weatherTower.conditionsChanged();

		if (weatherTower.getWeather(super.coordinates).equals("SUN"))
		{
			super.coordinates.setLatitude((super.coordinates.getLatitude() + 10 > 100) ? 100 : super.coordinates.getLatitude() + 10);
			super.coordinates.setHeight((super.coordinates.getHeight() + 2 > 100) ? 100 : super.coordinates.getHeight() + 2);
		}
		else if (weatherTower.getWeather(super.coordinates).equals("RAIN"))
			super.coordinates.setLatitude((super.coordinates.getLatitude() + 5 > 100) ? 100 : super.coordinates.getLatitude() + 5);
		else if (weatherTower.getWeather(super.coordinates).equals("FOG"))
			super.coordinates.setLatitude((super.coordinates.getLatitude() + 1 > 100) ? 100 : super.coordinates.getLatitude() + 1);
		else if (weatherTower.getWeather(super.coordinates).equals("SNOW")) {
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
