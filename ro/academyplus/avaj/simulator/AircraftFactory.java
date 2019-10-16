package ro.academyplus.avaj.simulator;

public class AircraftFactory {

    public AircraftFactory() {


    }

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
		Flyable	ac = null;
    	System.out.println("Call of function newAircraft.");

	if (height < 0)
		height = 0;
	else if (height > 100)
		height = 100;
	
	Coordinates coord = new Coordinates(longitude, latitude, height);
	if (type == "Helicopter")
		ac = new Helicopter(name, coord);
	else if (type == "JetPlane")
		ac = new JetPlane(name, coord);
	else if (type == "Baloon")
		 ac = new Baloon(name, coord);
	return ac;
    }
}
