package ro.academyplus.avaj.simulator;

public class                JetPlane extends Aircraft implements Flyable {

	private WeatherTower    weatherTower = new WeatherTower();

    public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
    }

	public void updateConditions() {	
		
		String mess = "default";
		String currweather = weatherTower.getWeather(super.coordinates);

		if (currweather.equals("SUN"))
		{
			mess = "Shine and sunny day to get your jetPlane out!";
			super.coordinates.setLatitude((super.coordinates.getLatitude() + 10 > 100) ? 100 : super.coordinates.getLatitude() + 10);
			super.coordinates.setHeight((super.coordinates.getHeight() + 2 > 100) ? 100 : super.coordinates.getHeight() + 2);
		}
		else if (currweather.equals("RAIN")) {
			mess = "It's raining. Better watch out for lightings.";
			super.coordinates.setLatitude((super.coordinates.getLatitude() + 5 > 100) ? 100 : super.coordinates.getLatitude() + 5);
		}
		else if (currweather.equals("FOG")) {
			mess = "Damned fog! I can't see a thing two feet away.";
			super.coordinates.setLatitude((super.coordinates.getLatitude() + 1 > 100) ? 100 : super.coordinates.getLatitude() + 1);
		}
		else if (currweather.equals("SNOW")) {
			mess = "OMG! Winter is coming!";
			super.coordinates.setHeight((super.coordinates.getHeight() >= 7) ? super.coordinates.getHeight() - 7 : 0);
		}
		System.out.println("JetPlane" + "#" + super.name + "(" + super.id + "): " + mess);
		if (coordinates.getHeight() > 100)
			coordinates.setHeight(100);
	}
    	public void registerTower(WeatherTower weatherTower) {
		
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}

}
