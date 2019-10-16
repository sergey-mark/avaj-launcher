package ro.academyplus.avaj.simulator;

//import ro.academyplus.avaj.simulator.Aircraft;
//import ro.academyplus.avaj.simulator.Flyable;

public class                Baloon extends Aircraft implements Flyable { 

    private WeatherTower    weatherTower;

    public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
		System.out.println("Call of class Baloon.");
		System.out.println(name);
		System.out.println(coordinates.getLatitude());
	}
	
    public void updateConditions() {	
		//System.out.println("updateConditions from Baloon !!!");
		weatherTower.conditionsChanged();
		System.out.println("Baloon" + "#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.");
		
	}
    public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
		//weatherTower.getWeather(coordinates);
		System.out.println("Tower says: " + "Baloon" + "#" + this.name + "(" + this.id + ") registered from weather tower.");
	}
        

}
