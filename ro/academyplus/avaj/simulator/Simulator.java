// Compile with:
//find . -name "*.java" > sources.txt && javac -sourcepath @sources.txt && java ro.academyplus.avaj.simulator.Simulator docs/scenario.txt

package ro.academyplus.avaj.simulator;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Simulator {

    public Simulator() {

    }

    public static void fileloader(String filename) {
        
            List<String> lines = null;
            Pattern pattern;
            Matcher matcher;
            Path fullpath = Paths.get(filename);
            AircraftFactory af = new AircraftFactory();
            int nbrWeather = 0;
            WeatherTower weatherTower = new WeatherTower();
            int i = 1;

            try {
                lines = Files.readAllLines(fullpath, StandardCharsets.UTF_8);
                // See pattern filtering here: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
                pattern = Pattern.compile("([0-9]+)");
                matcher = pattern.matcher(lines.get(0));
                if (matcher.find() && matcher.group() == lines.get(0)) {
                    nbrWeather = Integer.parseInt(matcher.group(1));
                } else {
                    System.out.println("Error line: " + lines.get(0));
                    return;
                }
                pattern = Pattern.compile("(Baloon|JetPlane|Helicopter) ([A-Za-z0-9]+) ([0-9]+) ([0-9]+) ([0-9]+)");
                while (i < lines.size()) {
                    matcher = pattern.matcher(lines.get(i));
                    if (matcher.find() && matcher.group() == lines.get(i)) {
                        int height = (Integer.parseInt(matcher.group(5)) > 100) ? 100 : Integer.parseInt(matcher.group(5));
                        
                        Flyable flyable = af.newAircraft(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), height);
                        flyable.registerTower(weatherTower);
                    } else {
                        System.out.println("Error line: " + lines.get(i));
                        return;
                    }
                    i++;
                }
            } // https://stackoverflow.com/questions/3776327/how-to-define-custom-exception-class-in-java-the-easiest-way
            // https://docs.oracle.com/javase/7/docs/api/java/io/FileNotFoundException.html
            catch (IOException ex) {
                System.out.println("Warning wrong file name or input file !");
                //ex.printStackTrace();
            }
	    catch (java.lang.IndexOutOfBoundsException ex) {
                System.out.println("Warning wrong Out of Bounds Exception !");
	    }
	    catch (java.lang.OutOfMemoryError ex) {
                System.out.println("Warning Out of memory Exception !");
	    }
	    catch (java.lang.NumberFormatException ex2) {
                System.out.println("Warning wrong format number exception !");
            }
            int j = 0;
            if (nbrWeather > 0) {
                while (j < nbrWeather) {
                    weatherTower.changeWeather();
                    j++;
                }
            }
    }
    public static void main(String[] args) {
	
	if (args.length == 1 && args[0] != null)
            fileloader(args[0]);
        else
            System.out.println("Warning ! Please put one scenario file!");
    }
    
}
