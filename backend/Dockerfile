# Dockerfile
FROM maven:3.9.5-eclipse-temurin-17 AS builder

WORKDIR /usr/src/
# pom.xmlだけCOPYし、先に依存解決
COPY ./pom.xml /usr/src/
RUN mvn -B package; echo ""

# ビルドで必要となるファイルのみCOPY
COPY ./src/ /usr/src/src/
RUN mvn -B package

FROM openjdk:17

COPY --from=builder /usr/src/target/arput-0.0.1-SNAPSHOT.jar /
ENV CLASSPATH /arput-0.0.1-SNAPSHOT.jar

ENTRYPOINT []
CMD ["java", "-jar", "/arput-0.0.1-SNAPSHOT.jar"]
