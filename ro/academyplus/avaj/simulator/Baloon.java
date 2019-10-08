package ro.academyplus.avaj.simulator;

import ro.academyplus.avaj.simulator.Aircraft;
import ro.academyplus.avaj.simulator.Flyable;

public class                Baloon extends Aircraft implements Flyable { 

    private WeatherTower    weatherTower;

    public Baloon(String name, Coordinates coordinates) {

    }
    	public void updateConditions() {	
		System.out.println("updateConditions from Baloon !!!");
	}
    	public void registerTower(WeatherTower weatherTower) {
		System.out.println("registerTower from Baloon !!!");
	}
        

}
