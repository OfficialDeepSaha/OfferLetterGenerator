FROM maven:3.8.5-openjdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-jdk-slim
COPY --from=build /target/OfferLetterGenerator-0.0.1-SNAPSHOT.jar OfferLetterGenerator.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","OfferLetterGenerator.jar"]