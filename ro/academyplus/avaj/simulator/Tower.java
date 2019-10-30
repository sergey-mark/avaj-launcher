package ro.academyplus.avaj.simulator;

import java.util.ArrayList;

public class Tower {

    // On cree un arrayList (liste chainee):
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {

        //System.out.println("Call of function register from Tower."); 
        observers.add( flyable ); // https://www.commentcamarche.net/forum/affich-5578263-creer-une-liste-avec-java
        String type = flyable.getClass().getTypeName().split("\\.")[4];
        switch (type) {
            case "Baloon": {
                Baloon baloon = Baloon.class.cast(flyable);
                System.out.println("Tower says: " + type + "#" + baloon.name + "(" + baloon.id + ") registered to weather tower.");
                break;
            }
            case "Helicopter": {
                Helicopter helicopter = Helicopter.class.cast(flyable);
                System.out.println("Tower says: " + type + "#" + helicopter.name + "(" + helicopter.id + ") registered to weather tower.");
                break;
            }
            case "JetPlane": {
                JetPlane jetplane = JetPlane.class.cast(flyable);
                System.out.println("Tower says: " + type + "#" + jetplane.name + "(" + jetplane.id + ") registered to weather tower.");
                break;
            }
        }
    }
    public void unregister(Flyable flyable) {

        //System.out.println("Call of function unregister from Tower."); 
        observers.remove( flyable );
        //System.out.println("UnRegister !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String type = flyable.getClass().getTypeName().split("\\.")[4];
        switch (type) {
            case "Baloon": {
                Baloon baloon = Baloon.class.cast(flyable);
                System.out.println("Tower says: " + type + "#" + baloon.name + "(" + baloon.id + ") unregistered from weather tower.");
                break;
            }
            case "Helicopter": {
                Helicopter helicopter = Helicopter.class.cast(flyable);
                System.out.println("Tower says: " + type + "#" + helicopter.name + "(" + helicopter.id + ") unregistered from weather tower.");
                break;
            }
            case "JetPlane": {
                JetPlane jetplane = JetPlane.class.cast(flyable);
                System.out.println("Tower says: " + type + "#" + jetplane.name + "(" + jetplane.id + ") unregistered from weather tower.");
                break;
            }
        }
    }
    protected void conditionsChanged() {

        //System.out.println("Call of function conditionsChanged from Tower."); 
        // We use observer pattern: https://www.baeldung.com/java-observer-pattern :
        // http://design-patterns.fr/observateur-en-java
        for(int i=0;i<observers.size();i++)
        {
            //System.out.println("Call of function conditionsChanged to updateConditions from Tower."); 
            Flyable o = observers.get(i);
            o.updateConditions();// On utilise la méthode "tiré".
        }



    }
   
}