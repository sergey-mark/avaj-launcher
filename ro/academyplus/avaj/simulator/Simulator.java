// Compile with:
//javac Simulator.java && java Simulator docs/scenario.txt

package ro.academyplus.avaj.simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {

    public Simulator() {

    }

    public static void fileloader(String filename) {
        
        File f = null;
        FileReader r = null;
        BufferedReader bfr = null;
        //String fullpath = "/Users/billettepy/work/avaj-launcher/" + filename; // At Home
        String fullpath = "/Users/pbillett/avaj-launcher/" + filename; // 42
        int i = 0;
        AircraftFactory af = null;
        int nbrWeather = 0;

        //System.out.println("Call of fileloader.");
        f = new File(fullpath);
        try {
            //System.out.println("Call of try");
            String temp = "";
            r = new FileReader(f);
            bfr = new BufferedReader(r);
            while ((temp = bfr.readLine()) != null) {
                System.out.println(temp);
                if (i == 0)
                    nbrWeather = Integer.parseInt(temp);
                else
                {
                    //System.out.println("Call of supersplit");
                    String[] parts = temp.split(" ");
                    af = new AircraftFactory();
                    af.newAircraft(parts[0],
                                parts[1],
                                Integer.parseInt(parts[2]),
                                Integer.parseInt(parts[3]),
                                Integer.parseInt(parts[4]));
                }
                i++;
            }
            System.out.println("Nbr of weather changes:" + nbrWeather);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            bfr.close();
        } catch (IOException ex) {
        }

    }
    public static void main(String[] args) {
        //System.out.println("Call of Class Simulator.");
        //System.out.println(args[0]);
        //System.out.println(args.length);
        try {
		    if (args[0] != null && args.length == 1)
        	{
                //System.out.println("ok inside");
                fileloader(args[0]); 
        	}
        } catch (Exception ex) {
        }
    }
    
}
