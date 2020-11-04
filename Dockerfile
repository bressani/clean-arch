FROM gradle:6.6.1-jdk11 as builder

WORKDIR /home/gradle/src

COPY build.gradle.kts .
COPY settings.gradle.kts .
RUN gradle dependencies --no-daemon

COPY . .

RUN gradle build --no-daemon

FROM openjdk:11-jre-slim-sid

EXPOSE 8080 8081
LABEL maintainer="Bressani"
LABEL version="1.0"

COPY --from=builder /home/gradle/src/build/libs/*.jar /app/clean-arch.jar

ADD entrypoint.sh /

ENTRYPOINT ["/entrypoint.sh"]