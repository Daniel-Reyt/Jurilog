# Stage 1
#FROM node:10-alpine as build-step
#RUN mkdir -p /app
#WORKDIR /app
#COPY package.json /app
#RUN npm install
#RUN npm i -g @angular/cli
#COPY . /app
#RUN ng serve

# Stage 2
# FROM nginx:1.17.1-alpine
# COPY --from=build-step /app/docs /usr/share/nginx/html

# pull official base image
FROM node as builder

# make directory
RUN mkdir -p /app
RUN chmod -R 777 /app

# set working directory
WORKDIR /app

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install app dependencies
COPY package.json .
COPY package-lock.json .
RUN npm install

# add app
COPY . .
RUN ls -li
#RUN yarn build
CMD ["npm","run","build"]
RUN ls

FROM nginx:stable-alpine
COPY --from=builder /app/dist/front /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
