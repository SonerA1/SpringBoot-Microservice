# SpringBoot-Microservice
## SpringBoot-Microservice

In the Product Service SpringBoot project: we organized the product add-deletion, update, operations with the help of APIs. We have become able to keep the list of microservices in the use of Eureka server, and we have facilitated the communication between the services. We have facilitated the access to the Zuul-Edge server. We have also strengthened the security between microservices.

## Requirements
-Spring Boot Microservice

-Spring Cloud

-Spring Framework

-REST API (REST Web Services)

-Spring Security

-Swagger

-Hibernate

-Lombok

-Jpa

-PostgreSql

-Postman

-Docker

## Building the project
-Java jdk 11
-Spring Boot 2.3.8 Release
-maven 4.0

## Dependencies
There are a number of third-party dependencies used in the project. Browse the Maven pom.xml file for details of libraries and versions used.

  <details>
  <summary>pom.xml:</summary>

    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.8.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>com.sonerA1.stockmanagement</groupId>
    <artifactId>product-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>product-service</name>
    <description>product-service</description>

    <properties>
        <java.version>11</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
        </dependency>

        <!-- Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!--Swagger-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
        <!--Lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

        <!--JPA-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <version>2.3.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.hsqldb</groupId>
            <artifactId>hsqldb</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Eureka -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            <version>2.2.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-netflix-eureka-client</artifactId>
            <version>2.2.5.RELEASE</version>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>


  </details>

 



## Project UI
<details>
  <summary>Spring Web:</summary>

  
![Ekran görüntüsü 2023-08-10 161559](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/5dd97bba-3f45-405c-a18c-3450995f3b82)
![Ekran görüntüsü 2023-08-10 161615](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/0951ff5c-df3d-442a-8a93-0d68feaf3794)
![Ekran görüntüsü 2023-08-10 161632](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/200090c4-5c0d-46fa-b58e-ab6bec54e721)


  </details>

  <details>
  <summary>EurekaServer:</summary>

  ![Ekran görüntüsü 2023-08-10 161809](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/cd33859e-aafc-4d15-a0b9-e2c042ddde3f)
  </details>

  <details>
  <summary>Zuul-Edge:</summary>

  ![Ekran görüntüsü 2023-08-10 161819](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/843c172f-6423-4530-9330-6721f869faa3)

  </details>

  <details>
  <summary>Postman:</summary>  
   
  ![Ekran görüntüsü 2023-08-10 162457](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/c6716b65-756b-453b-8842-ba6235c32d65)
  ![Ekran görüntüsü 2023-08-10 162521](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/9223c3b9-0fec-4273-ad97-713be08e61f4)
    
  </details>

  <details>
  <summary>PosgreSql:</summary>  
    
  ![Ekran görüntüsü 2023-08-10 162718](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/aa5051ab-28ef-4f7a-9253-527c31238039)

  </details>

  <details>
  <summary>Docker:</summary>    
    
  ![Ekran görüntüsü 2023-08-10 162413](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/08fd3d07-5162-4203-b669-cce902c61e39)

  </details>

   
