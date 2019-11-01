package ro.academyplus.avaj.simulator;

public class                Baloon extends Aircraft implements Flyable { 

	private WeatherTower    weatherTower = new WeatherTower();

    public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
	}
	
    public void updateConditions() {	

		String mess = "default";
		String currweather = weatherTower.getWeather(super.coordinates);
		
		if (currweather.equals("SUN"))
		{
			mess = "Let's enjoy the good weather and take some pics.";
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 2 > 100) ? 100 : super.coordinates.getLongitude() + 2);
			super.coordinates.setHeight((super.coordinates.getHeight() + 4 > 100) ? 100 : super.coordinates.getHeight() + 4);
		}
		else if (currweather.equals("RAIN")) {
			super.coordinates.setHeight((super.coordinates.getHeight() >= 5) ? super.coordinates.getHeight() - 5 : 0);
			mess = "Damn you rain! You messed up my baloon.";
		}
		else if (currweather.equals("FOG")) {
			mess = "Damned fog! I can't see a thing two feet away.";
			super.coordinates.setHeight((super.coordinates.getHeight() >= 3) ? super.coordinates.getHeight() - 3 : 0);
		}
		else if (currweather.equals("SNOW")) {
			mess = "It's snowing. We're gonna crash.";
			super.coordinates.setHeight((super.coordinates.getHeight() >= 15) ? super.coordinates.getHeight() - 15 : 0);
		}
		System.out.println("Baloon" + "#" + super.name + "(" + super.id + "): " + mess);
		if (coordinates.getHeight() > 100)
			coordinates.setHeight(100);
	}
    public void registerTower(WeatherTower weatherTower) {
		
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
        

}
