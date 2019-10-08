package ro.academyplus.avaj.simulator;

//import ro.academyplus.avaj.simulator.Aircraft;
//import ro.academyplus.avaj.simulator.Flyable;

public class                Baloon extends Aircraft implements Flyable { 

    private WeatherTower    weatherTower;

    public Baloon(String name, Coordinates coordinates) {
		//super();
		super(name, coordinates);
		System.out.println(name);
		System.out.println(coordinates.getLatitude());
		//super.name = name;
		//Aircraft.newInstance();
		//super() permet d'appeler le contructeur parent
	}
	
    public void updateConditions() {	
		//System.out.println("updateConditions from Baloon !!!");
		//Baloon#B1(1): Let's enjoy the good weather and take some pics.
		System.out.println("Baloon" + "#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.");
		weatherTower.conditionsChanged();
	}
    public void registerTower(WeatherTower weatherTower) {
		//System.out.println("registerTower from Baloon !!!");
		System.out.println("Tower says: " + "Baloon" + "#" + this.name + "(" + this.id + ") registered from weather tower.");
		//weatherTower.getWeather(coordinates);
		weatherTower.register(this);
	}
        

}
