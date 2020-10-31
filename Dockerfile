FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/juanmbrunodev/Spark_Dataframe_Example.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/Spark_Dataframe_Example /app
COPY --from=clone /app/Spark_Dataframe_Example/data/electronic-card-transactions.csv /app/data/electronic-card-transactions.csv
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR app
COPY --from=build /app/target/dataframe-basics-1.0-SNAPSHOT.jar /app
CMD ["java", "-jar",  "dataframe-basics-1.0-SNAPSHOT.jar"]