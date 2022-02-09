FROM node:lts as builder

RUN npm i -g @angular/cli

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

COPY package*.json /app/

RUN npm install --save

COPY . /app

EXPOSE 4200
