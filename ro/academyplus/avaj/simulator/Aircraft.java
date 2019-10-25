package ro.academyplus.avaj.simulator;

public class                  Aircraft {

    protected long            id;
    protected String          name;
    protected Coordinates     coordinates;
    static private long              idCounter = 0;

    protected Aircraft() {
    }

    protected Aircraft(String name, Coordinates coordinates) {

        this.coordinates = coordinates;
        this.name = name;
        this.id = this.nextId();
        System.out.println("id:" + this.id);
    }

    static private long nextId() {
        idCounter++;
        return idCounter;
    }

}
