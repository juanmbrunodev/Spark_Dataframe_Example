# Using official ubuntu image as a parent image
FROM ubuntu:latest

# Setting the working directory to /app
WORKDIR /dataframe_example

# Copy the current directory contents into the container at /app
COPY . /dataframe_example

# Getting the updates for Ubuntu and installing python into our environment
RUN apt-get -y update  &&  apt-get install openjdk-8-jdk

# Run app.py when the container launches
CMD ["python", "app.py"]