package ro.academyplus.avaj.simulator;

public class AircraftFactory {

    public AircraftFactory() {
		

    }

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
		Coordinates coord = new Coordinates(longitude, latitude, height);

		if (type.equals("Helicopter"))
			return new Helicopter(name, coord);
		else if (type.equals("JetPlane"))
			return new JetPlane(name, coord);
		else
			return new Baloon(name, coord);
		
    }
}
