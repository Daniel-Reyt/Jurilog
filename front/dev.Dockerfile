FROM node as builder

RUN mkdir -p /app
RUN chmod -R 777 /app

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

COPY . .
RUN npm install

COPY . .
CMD ["npm","run","start"]
