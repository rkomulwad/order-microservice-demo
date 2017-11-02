FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/shopping-cart-1.0.jar app.jar
ENV JAVA_OPTS=""

EXPOSE :8001

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar