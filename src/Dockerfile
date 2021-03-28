FROM maven:3.6.3-jdk-11 AS BUILDER

WORKDIR /app

COPY pom.xml .
COPY api/pom.xml ./api/
COPY application-contract/pom.xml ./application-contract/
COPY application/pom.xml ./application/
COPY domain/pom.xml ./domain/
COPY persistence/pom.xml ./persistence/
COPY shared-kernel/pom.xml ./shared-kernel/

RUN mvn verify --fail-never

COPY . .
RUN mvn clean install

FROM openjdk:11 AS RUNNER
WORKDIR /app
COPY --from=BUILDER /app/api/target/*.jar ./app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]