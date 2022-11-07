FROM maven:3.8-openjdk-8 as build
WORKDIR /home/build
ADD . /home/build
RUN mvn -DskipTests=true clean package
FROM openjdk:8
COPY --from=build /home/build/target/*.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java","-Dfile.encoding=UTF-8","-jar","./app.jar"]
CMD ["java","-jar","./app.jar"]