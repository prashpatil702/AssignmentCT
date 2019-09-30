FROM openjdk:8
EXPOSE 8080
ADD target/employeemgmt.jar employeemgmt.jar
ENTRYPOINT ["java","-jar","/employeemgmt.jar"]