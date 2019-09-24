

#TO START THE PROGRAM:

// To compile one file:
javac Fileloader.java
// To compile them all:
find . -name "*.java" > sources.txt && cat sources.txt
// To execute all files:
javac -sourcepath @sources.txt
// or to execute all packages and create respectives directory add -d options:
javac -d . *.java
// Then to execute:
java Fileloader docs/scenario.txt

#Notes:
    - La commande javac permet de compiler la classe Exo.java, ainsi le fichier Exo.class sera généré en absence d'erreur de compilation. 
    - La commande java permet d'exécuter le byte code, en passant un tableau de valeur à la méthode main. 

// To add package name at the beginning of a file:
echo $'package ro.academyplus.avaj.simulator;\n' | cat - JetPlane.java > temp && mv temp JetPlane.java

// And to add package name at the beginning of all java files in current directory:
for i in *.java ; do $(echo $'package ro.academyplus.avaj.simulator;\n' | cat - $i > temp && mv temp $i) ; done

