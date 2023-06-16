FROM openjdk:17-oracle

WORKDIR /app

COPY . /app

RUN ["./mvnw", "clean", "install"]

# CMD ["./mvnw", "spring-boot:run"]

ENTRYPOINT ["java", "-jar", "target/order-automation-module-0.0.1-SNAPSHOT.jar"]

EXPOSE 1313
