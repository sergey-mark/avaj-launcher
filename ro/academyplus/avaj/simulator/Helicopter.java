package ro.academyplus.avaj.simulator;

public class                Helicopter extends Aircraft implements Flyable {

    private WeatherTower    weatherTower;

    public Helicopter(String name, Coordinates coordinates) {

        super(name, coordinates); //super() permet d'appeler le contructeur parent
    }

	public void updateConditions() {	
		System.out.println("updateConditions from Baloon !!!");
	}
    	public void registerTower(WeatherTower weatherTower) {
		System.out.println("registerTower from Baloon !!!");
	}

}
