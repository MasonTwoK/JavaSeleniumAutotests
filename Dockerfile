# FROM alpine

# RUN apk update && apk upgrade
# RUN apk add openjdk17-jre-headless

# https://linuxhint.com/install-google-chrome-alpine-linux/
# RUN apk add chromium

FROM maven:3.9.2-eclipse-temurin-17-alpine

COPY ./pom.xml /tmp/pom.xml

COPY . /usr/src/mymaven
WORKDIR /usr/src/mymaven

CMD ["mvn clean test"]


EXPOSE 80