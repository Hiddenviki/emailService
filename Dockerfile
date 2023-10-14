# Общий Dockerfile
ARG ARCH
FROM openjdk:latest
ADD target/EmailService-0.0.1-SNAPSHOT.jar JavaEmailApp.jar
# Переменные среды
ENV RABBITMQ_HOST=rabbitmq
ENV RABBITMQ_PORT=5672
ENV SPRING_PROFILES_ACTIVE=production
ENTRYPOINT ["java","-jar","JavaEmailApp.jar"]
