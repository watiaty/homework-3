FROM gradle:latest AS BUILD
WORKDIR /app
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN gradle build

FROM openjdk:17-jdk
ENV ARTIFACT_NAME=order-service-0.0.1-SNAPSHOT.jar
WORKDIR /app
COPY --from=BUILD /app/build/libs/$ARTIFACT_NAME .

ENTRYPOINT exec java -jar ${ARTIFACT_NAME}