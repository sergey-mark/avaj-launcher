package ro.academyplus.avaj.simulator;

public class                JetPlane extends Aircraft implements Flyable {

    private WeatherTower    weatherTower;

    public JetPlane(String name, Coordinates coordinates) {

        
    }

	public void updateConditions() {	
		System.out.println("updateConditions from Baloon !!!");
	}
    	public void registerTower(WeatherTower weatherTower) {
		System.out.println("registerTower from Baloon !!!");
	}

}
