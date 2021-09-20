FROM node as builder

RUN mkdir -p /app
RUN chmod -R 777 /app

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

COPY package.json .
COPY package-lock.json .
RUN npm install
RUN npm install bootstrap

COPY . .
CMD ["npm","run","build"]

FROM nginx:stable-alpine
COPY --from=builder /app/dist/front /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
