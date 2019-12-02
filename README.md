### Environments:
       this project was developed under java 1.8 and build with maven 3.x

### How to build the project:
        
        mvn clean package 
        
        
### How to run the project:
       You can use this command that builds and runs the project(you have to mention the real paths of input and output files):
       
                    mvn clean package exec:java -Dexec.mainClass="trips.costs.App" -Dexec.args="inuptFilePath outputFilePath"
    
        
       The project also build an executable jar so you can use this method:
        
       1. Build the projet
       2. Change the working directory to the"target" folder and the locate the jar("jar-with-dependencies" suffix in the name of the jar )
       3. Run this command(you have to mention the real paths of input and output files):
       
                    java -jar costs-0.0.1-SNAPSHOT-jar-with-dependencies.jar inuptFilePath outputFilePath
