FROM openjdk:17-jdk-slim
WORKDIR /app
RUN apt-get update && \
    apt-get install -y fonts-dejavu-core fontconfig && \
    rm -rf /var/lib/apt/lists/*
COPY target/Inventario-TI-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-jar", "app.jar"]