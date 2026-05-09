FROM gradle:8.4-jdk21 AS builder

WORKDIR /app

COPY gradlew ./
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./
COPY src src

RUN ./gradlew bootJar -x test --no-daemon

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]