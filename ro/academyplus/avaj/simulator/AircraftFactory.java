import ro.academuplus.avaj.simulator.Simulator;

public class AircraftFactory {

    public AircraftFactory() {


    }

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        System.out.println("Call of function newAircraft.");
        Coordinates coord = new Coordinates(longitude, latitude, height);
        if (type == "Helicopter")
            ac = new Helicopter(name, coord);
        else if (type == "JetPlane")
            ac = new JetPlane(name, coord);
        else if (type == "Baloon")
            ac = new Baloon(name, coord);
    }
}