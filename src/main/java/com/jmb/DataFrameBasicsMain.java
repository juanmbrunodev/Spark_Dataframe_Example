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
        
        SparkConf appConfig = new SparkConf();

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

        //Show the first 15 rows
        df.show(15);
    }
}
