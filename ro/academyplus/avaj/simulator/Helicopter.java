package ro.academyplus.avaj.simulator;

public class                Helicopter extends Aircraft implements Flyable {

	private WeatherTower    weatherTower = new WeatherTower();

    public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
	}

	public void updateConditions() {
		
		String mess = "default";
		String currweather = weatherTower.getWeather(super.coordinates);

		if (currweather.equals("SUN"))
		{
			mess = "This is hot.";
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 10 > 100) ? 100 : super.coordinates.getLongitude() + 10);
			super.coordinates.setHeight((super.coordinates.getHeight() + 2 > 100) ? 100 : super.coordinates.getHeight() + 2);
		}
		else if (currweather.equals("RAIN")) {
			mess = "Damn you rain!";
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 5 > 100) ? 100 : super.coordinates.getLongitude() + 5);
		} 
		else if (currweather.equals("FOG")) {
			mess = "Damned fog! I can't see a thing two feet away.";
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 1 > 100) ? 100 : super.coordinates.getLongitude() + 1);
		}
		else if (currweather.equals("SNOW")) {
			mess = "My rotor is going to freeze!";
			super.coordinates.setHeight((super.coordinates.getHeight() >= 12) ? super.coordinates.getHeight() - 12 : 0);
		}
		System.out.println("Helicopter" + "#" + super.name + "(" + super.id + "): " + mess);
		if (coordinates.getHeight() > 100)
			coordinates.setHeight(100);
		
	}
    public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}

}
