FROM openjdk:11
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY target/RetoCRUDMicro-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 9090
CMD ["java", "-jar", "app.jar"]