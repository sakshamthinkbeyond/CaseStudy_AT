FROM openjdk
EXPOSE 8084
WORKDIR /app
COPY target/eureka.jar /app/eureka.jar
ENTRYPOINT ["java", "-jar","eureka.jar"]