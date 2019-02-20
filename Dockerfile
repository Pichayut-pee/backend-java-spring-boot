# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine


# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file

ARG JAR_FILE=build/libs/ptvn-op-contract-api-latest.jar


#WORKDIR /root/.jenkins/workspace/ptvn-contract-api_master
#COPY ./ ./
# Add the application's jar to the container
ADD ${JAR_FILE} ptvn-op-contract-api.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/ptvn-op-contract-api.jar"]