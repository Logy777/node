FROM node:12

WORKDIR /app

RUN npm install

COPY package.json /app

COPY . /app

EXPOSE 80

CMD ["node", "server.js"]