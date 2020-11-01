#Sample DataFrame Spark Project

Project contains a simple main class to read from a csv file into a Spark Java Dataset (Dataframe) object.

## How to run

This project uses the maven run plugin behind the scenes, and comes with all the maven dependencies needed to run the 
Spark application in standalone (isolated) manner (No Spark local installation is needed)

*mvn clean install exec:exec*