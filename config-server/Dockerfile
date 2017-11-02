FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/config-server-1.0.jar app.jar
ENV JAVA_OPTS=""

EXPOSE :5001

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar