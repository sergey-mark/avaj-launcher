package ro.academyplus.avaj.simulator;

public class                  Aircraft {

    protected long            id;
    protected String          name;
    protected Coordinates     coordinates;
    private long              idCounter = 0;

    protected Aircraft() {
    }

    protected Aircraft(String name, Coordinates coordinates) {

        this.coordinates = coordinates;
        this.names = names;
        this.id = this.nextId();
    }

    private long nextId() {

        this.idCounter++;
    }

}
