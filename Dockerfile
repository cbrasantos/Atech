FROM gradle:jdk10 as builder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle clean build

###################################################

FROM openjdk:10-jre-slim

EXPOSE 8095

COPY --from=builder /home/gradle/src/build/libs/*.jar /app/

RUN apt-get update && \
    apt-get install -y curl 

WORKDIR /app/

ENTRYPOINT [ "java", "-jar", "/app/empresa-aerea.jar"]
