# Etapa de construcción
FROM eclipse-temurin:17-jdk AS build
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jre
ARG PORT
#Valor por defecto si no se establece PORT
ENV PORT=${PORT}
COPY --from=build /app/target/*.jar app.jar
RUN useradd runtime
USER runtime
#ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
ENTRYPOINT [ "java", "-jar", "app.jar", "-Dserver.port=${PORT}" ]