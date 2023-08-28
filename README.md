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
  <summary>pom.xml: product-service</summary>

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

<details>
  <summary>pom.xml:eureka-server</summary>
  
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
    <groupId>com.sonera1.stockmanagement</groupId>
    <artifactId>eureka-server</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>eureka-server</name>
    <description>eureka-server</description>
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
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
            <version>2.2.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
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

  <details>
  <summary>pom.xml:zuul-edge-server</summary>
  
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
    <groupId>com.sonera1.stockmanagement</groupId>
    <artifactId>zuul-edge-server</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>zuul-edge-server</name>
    <description>zuul-edge-server</description>
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
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            <version>2.2.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
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



<details>
  <summary>pom.xml:product-cache-service</summary>
  
     <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.8</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.sonera1.stockmanagement</groupId>
    <artifactId>product-cache-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>product-cache-service</name>
    <description>product-cache-service</description>
    <properties>
        <java.version>11</java.version>
    </properties>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>2021.0.4</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            <version>3.1.3</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <!-- Feign Client -->
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
            <version>3.0.8</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <!--REDIS-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>webjars-locator-core</artifactId>
            <version>0.52</version>
        </dependency>
        <dependency>
            <!--Openapi-->
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-ui</artifactId>
            <version>1.6.14</version>
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
  ![Ekran görüntüsü 2023-08-28 101019](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/98409504-cb76-475a-b0d6-2da21e56a992)
  ![Ekran görüntüsü 2023-08-28 101058](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/fa47e313-8ee8-4619-953e-917578fcaa5e)
  ![Ekran görüntüsü 2023-08-28 113536](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/57d655fa-2609-469d-acdd-3c507fdd3b94)


  </details>

  <details>
  <summary>Zuul-Edge:</summary>

  ![Ekran görüntüsü 2023-08-27 170728](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/10c26b68-5ebd-4de5-aee6-2e91b8130bdb)


  </details>

   <details>
  <summary>Product-cache-service:</summary>   

  ![Ekran görüntüsü 2023-08-28 130919](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/ce13ea66-0b55-4fd6-ad98-234d661fde10)
    
  

  </details>

  <details>
  <summary>Postman:</summary>  
   
  ![Ekran görüntüsü 2023-08-27 162316](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/5943c566-30b4-4a82-8750-8948f3f7997c)
  ![Ekran görüntüsü 2023-08-27 162208](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/83587ce4-46b7-44e6-859c-93c795605fc7)
  ![Ekran görüntüsü 2023-08-27 162300](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/032301f1-2c65-4008-ba12-f2d31942bcf3)
    
  </details>

  <details>
  <summary>PosgreSql:</summary>  
    
  ![Ekran görüntüsü 2023-08-10 162718](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/aa5051ab-28ef-4f7a-9253-527c31238039)
  ![Ekran görüntüsü 2023-08-28 140134](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/672625d3-e9c2-4d25-81b0-32648cff8013)


  </details>

  <details>
  <summary>Docker:</summary>    
    
  ![Ekran görüntüsü 2023-08-28 103355](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/eb99eda4-c9cf-4557-8d9b-172c448fc35f)
![Ekran görüntüsü 2023-08-28 135811](https://github.com/SonerA1/SpringBoot-Microservice/assets/114054564/b62ac8f3-0cb9-4621-8772-383d000fec02)

  </details>

 


   
