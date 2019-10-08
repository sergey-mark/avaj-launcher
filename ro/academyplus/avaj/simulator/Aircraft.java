package ro.academyplus.avaj.simulator;

public class        Aircraft {

    protected long            id;
    protected String          name;
    protected Coordinates     coordinates;
    private long              idCounter = 0;

    public Aircraft() {

    }
    private Aircraft(String name, Coordinates coordinates) {

        this.nextId();
    }

    private long nextId() {

        return idCounter++;
    }

}
