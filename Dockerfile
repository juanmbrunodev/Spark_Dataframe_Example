FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/juanmbrunodev/Spark_Dataframe_Example.git
RUN git clone https://github.com/juanmbrunodev/spark_data.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/Spark_Dataframe_Example /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR app
COPY --from=build /app/target/dataframe-basics-1.0-SNAPSHOT-jar-with-dependencies.jar /app
COPY --from=build /app/target/classes/spark-data/ /app/spark-data
CMD ["java", "-jar",  "dataframe-basics-1.0-SNAPSHOT-jar-with-dependencies.jar"]