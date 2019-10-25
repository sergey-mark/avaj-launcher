package ro.academyplus.avaj.simulator;

public class                Helicopter extends Aircraft implements Flyable {

    private WeatherTower    weatherTower = null;

    public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
		System.out.println("Call of class Helicopter.");
		this.registerTower(weatherTower);
		//updateConditions();
		//weatherTower.conditionsChanged();
    }

	public void updateConditions() {
		System.out.println("updateConditions from Helictopter !!!");
		
		String mess = "default";
		String currweather = weatherTower.getWeather(super.coordinates);

		//System.out.println(weatherTower.getWeather(super.coordinates));
		if (currweather.equals("SUN"))
		{
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 10 > 100) ? 100 : super.coordinates.getLongitude() + 10);
			super.coordinates.setHeight((super.coordinates.getHeight() + 2 > 100) ? 100 : super.coordinates.getHeight() + 2);
		}
		else if (currweather.equals("RAIN")) {
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 5 > 100) ? 100 : super.coordinates.getLongitude() + 5);
		} 
		else if (currweather.equals("FOG")) {
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 1 > 100) ? 100 : super.coordinates.getLongitude() + 1);
		}
		else if (currweather.equals("SNOW")) {
			super.coordinates.setHeight((super.coordinates.getHeight() >= 12) ? super.coordinates.getHeight() - 12 : 0);
		}
		System.out.println("Helicopter" + "#" + super.name + "(" + super.id + "): " + mess);
		if (super.coordinates.getHeight() == 0) //If an aircraft reaches height 0 or needs to go below unregisters from the weather tower
			this.weatherTower.unregister(this);
		
	}
    public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
		System.out.println("Tower says: " + "Helicopter" + "#" + super.name + "(" + super.id + ") registered from weather tower.");
	}

}
