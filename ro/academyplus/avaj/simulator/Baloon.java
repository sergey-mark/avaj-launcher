package ro.academyplus.avaj.simulator;

public class                Baloon extends Aircraft implements Flyable { 

	private WeatherTower    weatherTower = null;
	//private WeatherTower    weatherTower = new WeatherTower();

	/*
	"It's raining. Better watch out for lightings."
	"This is hot"
	"My rotor is going to freeze!"

	
	JetPlane#J1(2): OMG! Winter is coming!
	Helicopter#H1(3): This is hot.
	Helicopter#H4(4): My rotor is going to freeze!

	Baloon#B1(1): 
JetPlane#J1(2): It's raining. Better watch out for lightings.
Helicopter#H1(3): This is hot.
Helicopter#H4(4): My rotor is going to freeze!

Baloon#B1(1): 
Baloon#B1(1) landing.
Tower says: Baloon#B1(1) unregistered from weather tower.
JetPlane#J1(2): OMG! Winter is coming!*/

    public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates); //super() permet d'appeler le contructeur parent
		System.out.println("Call of class Baloon.");
		this.registerTower(weatherTower);
		//weatherTower.getWeather(coordinates);
		//updateConditions();
		//weatherTower.conditionsChanged();
	}
	
    public void updateConditions() {	
		System.out.println("updateConditions from Baloon !!!");

		String mess = "default";
		String currweather = weatherTower.getWeather(super.coordinates);

		//System.out.println(currweather + " equal(SUN): " + currweather.equals("SUN") + "?");
		if (currweather.equals("SUN"))
		{
			//System.out.println("SUN !!!");
			mess = "Let's enjoy the good weather and take some pics.";
			super.coordinates.setLongitude((super.coordinates.getLongitude() + 2 > 100) ? 100 : super.coordinates.getLongitude() + 2);
			super.coordinates.setHeight((super.coordinates.getHeight() + 4 > 100) ? 100 : super.coordinates.getHeight() + 4);
		}
		else if (currweather.equals("RAIN")) {
			//System.out.println("RAIN !!!");
			super.coordinates.setHeight((super.coordinates.getHeight() >= 5) ? super.coordinates.getHeight() - 5 : 0);
			mess = "Damn you rain! You messed up my baloon.";
		}
		else if (currweather.equals("FOG")) {
			//System.out.println("FOG !!!");
			mess = "Damned fog! I can't see a thing two feet away.";
			super.coordinates.setHeight((super.coordinates.getHeight() >= 3) ? super.coordinates.getHeight() - 3 : 0);
		}
		else if (currweather.equals("SNOW")) {
			//System.out.println("SNOW !!!");
			mess = "It's snowing. We're gonna crash.";
			super.coordinates.setHeight((super.coordinates.getHeight() >= 15) ? super.coordinates.getHeight() - 15 : 0);
		}
		System.out.println("Baloon" + "#" + super.name + "(" + super.id + "): " + mess);
		if (super.coordinates.getHeight() == 0) //If an aircraft reaches height 0 or needs to go below unregisters from the weather tower
			this.weatherTower.unregister(this);
	}
    public void registerTower(WeatherTower weatherTower) {
		
		weatherTower.register(this);
		System.out.println("Tower says: " + "Baloon" + "#" + this.name + "(" + super.id + ") registered from weather tower.");
	}
        

}
