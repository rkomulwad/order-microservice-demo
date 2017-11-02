FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/gateway-1.0.jar app.jar
ENV JAVA_OPTS=""

EXPOSE :9000

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar