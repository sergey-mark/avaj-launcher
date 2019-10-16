package ro.academyplus.avaj.simulator;

public class                Baloon extends Aircraft implements Flyable { 

	private WeatherTower    weatherTower = new WeatherTower();
	private String			name;

    public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
		System.out.println("Call of class Baloon.");
		System.out.println(name);
		this.name = name;
		System.out.println(coordinates.getLatitude());
		this.registerTower(weatherTower);
		weatherTower.getWeather(coordinates);
	}
	
    public void updateConditions() {	
		//System.out.println("updateConditions from Baloon !!!");
		weatherTower.conditionsChanged();
		System.out.println("Baloon" + "#" + this.name + "(" + super.id + "): Let's enjoy the good weather and take some pics.");
		
	}
    public void registerTower(WeatherTower weatherTower) {
		
		weatherTower.register(this);
		System.out.println("Tower says: " + "Baloon" + "#" + this.name + "(" + super.id + ") registered from weather tower.");
	}
        

}
