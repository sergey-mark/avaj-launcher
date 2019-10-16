package ro.academyplus.avaj.simulator;

public class Tower {

    private Flyable observers;

    public void register(Flyable flyable) {
        
        //System.out.println("Tower says: " + observers.type + "#" + name + "(" + observers.idCounter + ") registered from weather tower."); 
    }
    public void unregister(Flyable flyable) {

        //System.out.println("Tower says: " + observers.type + "#" + name + "(" + observers.idCounter + ") unregistered from weather tower."); 
    }
    protected void conditionsChanged() {

        
    }
}