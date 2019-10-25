package ro.academyplus.avaj.simulator;

public class                Helicopter extends Aircraft implements Flyable {

    private WeatherTower    weatherTower = new WeatherTower();

    public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
		System.out.println("Call of class Helicopter.");
		this.registerTower(weatherTower);
		//updateConditions();
    }

	public void updateConditions() {
		System.out.println("updateConditions from Helictopter !!!");
		weatherTower.conditionsChanged();
		System.out.println(weatherTower.getWeather(super.coordinates));
		if (weatherTower.getWeather(super.coordinates).equals("SUN"))
		{
			System.out.println("SUN !!!");
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 10 > 100) ? 100 : super.coordinates.getLongitude() + 10);
			super.coordinates.setHeight((super.coordinates.getHeight() + 2 > 100) ? 100 : super.coordinates.getHeight() + 2);
		}
		System.out.println("updateConditionsA from Helictopter !!!");
		if (weatherTower.getWeather(super.coordinates).equals("RAIN"))
		{
			System.out.println("RAIN !!!");
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 5 > 100) ? 100 : super.coordinates.getLongitude() + 5);
		}
		System.out.println("updateConditionsB from Helictopter !!!");
		if (weatherTower.getWeather(super.coordinates).equals("FOG"))
		{
			System.out.println("FOG !!!");
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 1 > 100) ? 100 : super.coordinates.getLongitude() + 1);
		}
		System.out.println("updateConditionsC from Helictopter !!!");
		if (weatherTower.getWeather(super.coordinates).equals("SNOW")) {
			System.out.println("SNOW !!!");
			super.coordinates.setHeight((super.coordinates.getHeight() >= 12) ? super.coordinates.getHeight() - 12 : 0);
		}
		System.out.println("Helicopter" + "#" + super.name + "(" + super.id + "): Let's enjoy the good weather and take some pics.");
		if (super.coordinates.getHeight() == 0) //If an aircraft reaches height 0 or needs to go below unregisters from the weather tower
			this.weatherTower.unregister(this);
		
	}
    public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
		System.out.println("Tower says: " + "Baloon" + "#" + super.name + "(" + super.id + ") registered from weather tower.");
	}

}
