############################################################
# Dockerfile to run Java
# Based on Ubuntu Image
############################################################

# Set the base image to use to Ubuntu
# FROM ubuntu:19.04

FROM node:10-alpine as node

WORKDIR /usr/src/app

RUN ls /usr/src/app

RUN npm install -g @angular/cli

COPY frontend/package.json /usr/src/app

RUN npm install

COPY . .

RUN npm start

FROM nginx:1.13.3-alpine
## Remove default nginx website

#COPY /nginx/default.conf /etc/nginx/conf.d/

RUN rm -rf /usr/share/nginx/html/*
## From 'builder' stage copy over the artifacts in dist folder to default nginx public folder

COPY frontend/dist/app /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]