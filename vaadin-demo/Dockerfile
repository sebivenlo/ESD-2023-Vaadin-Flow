FROM maven:3.9.5-eclipse-temurin-17-focal
WORKDIR /usr/app
COPY . .
EXPOSE 8080
RUN mvn clean install
ENTRYPOINT ["mvn"]
