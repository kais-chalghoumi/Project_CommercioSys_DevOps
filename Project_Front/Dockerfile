# Stage 1: Compile and Build angular codebase
FROM node:16.18.0 As build
WORKDIR /app
COPY package*.json ./
RUN npm install -f
COPY . .
RUN npm run build
# Stage 2: Serve app with nginx server
FROM nginx:latest
COPY --from=build ./ /usr/share/nginx/html
EXPOSE 4200
CMD [ "nginx", "-g", "daemon off;" ]