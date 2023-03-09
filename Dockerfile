FROM openjdk:17-oracle
ADD target/order-automation-module-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 1313