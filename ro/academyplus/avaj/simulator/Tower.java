package ro.academyplus.avaj.simulator;

import java.util.ArrayList;

public class Tower {

    // On cree un arrayList (liste chainee):
    private ArrayList<Flyable> observers = new ArrayList<Flyable>(); 

    public void register(Flyable flyable) {
        observers.add( flyable ); // https://www.commentcamarche.net/forum/affich-5578263-creer-une-liste-avec-java
        System.out.println("Tower says: " + "Baloon" + "#" + super.id + "(" + observers.name + ") registered from weather tower."); 
    }
    public void unregister(Flyable flyable) {

        //observers.remove( flyable );
        System.out.println("Tower says: " + flyable.id + "#" + flyable.name + "(" + flyable.idCounter + ") unregistered from weather tower with longitude: " + flyable.coordinates.getLongitude() + " latitude: " + flyable.coordinates.getLatitude() + " height: " + flyable.coordinates.getHeight() + "."); 
    }
    protected void conditionsChanged() {

        
    }
}