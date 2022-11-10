FROM adoptopenjdk/openjdk11

EXPOSE 8080

COPY  target/netology_spring_boot_rest-0.0.1-SNAPSHOT.jar javaApp.jar

CMD ["java", "-jar", "javaApp.jar"]
