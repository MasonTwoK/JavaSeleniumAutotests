FROM maven:3.9.3-eclipse-temurin-17-alpine

RUN apk add chromium-chromedriver

RUN apk update
RUN apk add zip


COPY ./pom.xml /tmp/pom.xml
# RUN mvn -B -f /tmp/pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve


COPY . /usr/src/mymaven
WORKDIR /usr/src/mymaven

CMD ["mvn", "clean", "test"]

EXPOSE 80