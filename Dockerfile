FROM maven:3.9.3-eclipse-temurin-17-alpine

RUN apk update && apk upgrade

RUN apk add chromium
RUN apk add chromium-chromedriver


COPY . /usr/src/mymaven
WORKDIR /usr/src/mymaven


CMD ["mvn", "clean", "test"]

EXPOSE 80