FROM openjdk:8
VOLUME /tmp
ADD build/libs/service-registry-1.0.jar app.jar

RUN sh -c 'touch /app.jar'

ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE docker

EXPOSE :5000

#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.active.profiles=docker -jar /app.jar