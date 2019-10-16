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

        observers.remove( flyable );
        //System.out.println("Tower says: " + observers.type + "#" + name + "(" + observers.idCounter + ") unregistered from weather tower."); 
    }
    protected void conditionsChanged() {

        
    }
}