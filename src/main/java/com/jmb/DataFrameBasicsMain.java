package com.jmb;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class DataFrameBasicsMain {

    private static final String APP_NAME = "DataFrameBasics";
    private static final String LOCAL_NODE_ID = "local";
    private static final String FORMAT = "csv";


    public static void main(String[] args) {

        DataFrameBasicsMain dataFrameBasicsMain = new DataFrameBasicsMain();
        dataFrameBasicsMain.init();
    }

    private static void init() {
        
        SparkConf appConfig = new SparkConf().set("spark.testing.memory", "200000000");

        //Create the spark session on the localhost master node
        SparkSession sparkSession = SparkSession.builder()
                .appName(APP_NAME)
                .master(LOCAL_NODE_ID)
                .config(appConfig)
                .getOrCreate();

        // Reads a CSV file with header, stores it in a DataFrame
        Dataset<Row> df = sparkSession.read().format(FORMAT)
                .option("header", "true")
                .load("src/main/resources/spark-data/electronic-card-transactions.csv");

        /*Uncomment if running from Docker Image, and replace above with this
                        .load("spark-data/electronic-card-transactions.csv");

        This also means that for docker, the csv file with the information to process should be located in a
        folder in the same directory as this project */

        //Show the first 15 rows
        df.show(15);
    }
}
