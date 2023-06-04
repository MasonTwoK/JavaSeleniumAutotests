FROM alpine

RUN apk update && apk upgrade

RUN apk add openjdk17-jre-headless
RUN apk add maven

# https://linuxhint.com/install-google-chrome-alpine-linux/
RUN apk add chromium

WORKDIR /test
COPY . /test