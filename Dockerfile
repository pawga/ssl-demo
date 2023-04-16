FROM openjdk:19-jdk-alpine as builder
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:19-jdk-alpine
RUN mkdir /app/
COPY --from=builder dependencies/ /app/
COPY --from=builder spring-boot-loader/ /app/
COPY --from=builder snapshot-dependencies/ /app/
COPY --from=builder application/ /app/

VOLUME /app/config
VOLUME /app/logs

WORKDIR /app

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
