FROM eclipse-temurin:17-jdk-jammy
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN ./mvnw clean install
ENTRYPOINT ["./mvnw"]
