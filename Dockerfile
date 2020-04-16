FROM adoptopenjdk:11.0.6_10-jre-hotspot

#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring

#COPY --chown=spring:spring ../server/target/*.jar /home/docker/app/app.jar
COPY server/target/*.jar /home/docker/app/app.jar

ENTRYPOINT ["java","-jar","/home/docker/app/app.jar"]

EXPOSE 8080
