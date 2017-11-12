FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/config-server-1.0.jar app.jar

#ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh wait-for-it.sh
#RUN sh -c 'chmod +x wait-for-it.sh'

RUN sh -c 'touch /app.jar'

ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE docker

EXPOSE :5001

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.active.profiles=docker -jar /app.jar