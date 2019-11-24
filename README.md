# MyTask
The application is used for post and get information about customer credit.

##Technologies
Project is created on Windows 10 within:
* Java: 8
* Apache Maven: 3.6.2
* Spring boot: 2.1.5.RELEASE
* MySQL: 
* Docker: 19.03.5

##Setup
Install Docker for Windows.

Before starting the project, check if docker is running and firewall is blocking file Sharing between Windows and the containers.

If not then write this in PowerShell on Windows
```
 Set-NetConnectionProfile -interfacealias "vEthernet (DockerNAT)" -NetworkCategory Private
```
Now you can start commpile project.

Go to folder MyTask in PowerShell and write:

```
PS C:\Users\patry\Documents\GitHub\MyTask>mvn clean install docker:build
[INFO] Built springboot/springboot-credit
[INFO] Tagging springboot/springboot-credit with 1.0-SNAPSHOT
[INFO] Tagging springboot/springboot-credit with latest
[INFO]
[INFO] -------------------< com.product:springboot-product >-------------------
[INFO] Building springboot-product 1.0-SNAPSHOT                           [2/4]
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ springboot-product ---
[INFO] Deleting C:\Users\patry\Documents\GitHub\MyTask\product\target
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ springboot-product ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ springboot-product ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 7 source files to C:\Users\patry\Documents\GitHub\MyTask\product\target\classes
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ springboot-product ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\patry\Documents\GitHub\MyTask\product\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ springboot-product ---
[INFO] Changes detected - recompiling the module!
[INFO]
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ springboot-product ---
[INFO]
[INFO] --- maven-jar-plugin:3.1.2:jar (default-jar) @ springboot-product ---
[INFO] Building jar: C:\Users\patry\Documents\GitHub\MyTask\product\target\springboot-product-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.1.5.RELEASE:repackage (repackage) @ springboot-product ---
[INFO] Replacing main artifact with repackaged archive
[INFO]
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ springboot-product ---
[INFO] Installing C:\Users\patry\Documents\GitHub\MyTask\product\target\springboot-product-1.0-SNAPSHOT.jar to C:\Users\patry\.m2\repository\com\product\springboot-product\1.0-SNAPSHOT\springboot-product-1.0-SNAPSHOT.jar
[INFO] Installing C:\Users\patry\Documents\GitHub\MyTask\product\pom.xml to C:\Users\patry\.m2\repository\com\product\springboot-product\1.0-SNAPSHOT\springboot-product-1.0-SNAPSHOT.pom
[INFO]
[INFO] --- docker-maven-plugin:1.2.1:build (default) @ springboot-product ---
[INFO] Using authentication suppliers: [ConfigFileRegistryAuthSupplier]
[INFO] Copying C:\Users\patry\Documents\GitHub\MyTask\product\target\springboot-product-1.0-SNAPSHOT.jar -> C:\Users\patry\Documents\GitHub\MyTask\product\target\docker\springboot-product-1.0-SNAPSHOT.jar
[INFO] Copying src\main\docker\Dockerfile -> C:\Users\patry\Documents\GitHub\MyTask\product\target\docker\Dockerfile
[INFO] Building image springboot/springboot-product
Step 1/5 : FROM openjdk:8

 ---> 09df0563bdfc
Step 2/5 : VOLUME /tmp

 ---> Using cache
 ---> b28fdf39e23c
Step 3/5 : ARG JAR_FILE

 ---> Using cache
 ---> ec630433071c
Step 4/5 : COPY ${JAR_FILE} app.jar

 ---> e6eb704e7b8b
Step 5/5 : ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

 ---> Running in c233bad24499
Removing intermediate container c233bad24499
 ---> d8954c85c904
ProgressMessage{id=null, status=null, stream=null, error=null, progress=null, progressDetail=null}
Successfully built d8954c85c904
Successfully tagged springboot/springboot-product:latest
[INFO] Built springboot/springboot-product
[INFO] Tagging springboot/springboot-product with 1.0-SNAPSHOT
[INFO] Tagging springboot/springboot-product with latest
[INFO]
[INFO] --- docker-maven-plugin:1.2.1:build (default-cli) @ springboot-product ---
[INFO] Using authentication suppliers: [ConfigFileRegistryAuthSupplier]
[INFO] Copying C:\Users\patry\Documents\GitHub\MyTask\product\target\springboot-product-1.0-SNAPSHOT.jar -> C:\Users\patry\Documents\GitHub\MyTask\product\target\docker\springboot-product-1.0-SNAPSHOT.jar
[INFO] Copying src\main\docker\Dockerfile -> C:\Users\patry\Documents\GitHub\MyTask\product\target\docker\Dockerfile
[INFO] Building image springboot/springboot-product
Step 1/5 : FROM openjdk:8

 ---> 09df0563bdfc
Step 2/5 : VOLUME /tmp

 ---> Using cache
 ---> b28fdf39e23c
Step 3/5 : ARG JAR_FILE

 ---> Using cache
 ---> ec630433071c
Step 4/5 : COPY ${JAR_FILE} app.jar

 ---> Using cache
 ---> e6eb704e7b8b
Step 5/5 : ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

 ---> Using cache
 ---> d8954c85c904
ProgressMessage{id=null, status=null, stream=null, error=null, progress=null, progressDetail=null}
Successfully built d8954c85c904
Successfully tagged springboot/springboot-product:latest
[INFO] Built springboot/springboot-product
[INFO] Tagging springboot/springboot-product with 1.0-SNAPSHOT
[INFO] Tagging springboot/springboot-product with latest
[INFO]
[INFO] ------------------< com.customer:springboot-customer >------------------
[INFO] Building springboot-customer 1.0-SNAPSHOT                          [3/4]
[INFO] --------------------------------[ jar ]---------------------------------
.
.
.
[INFO] -----------------------< com.task:start-project >-----------------------
[INFO] Building start-project 1.0-SNAPSHOT                                [4/4]
[INFO] --------------------------------[ pom ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ start-project ---
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ start-project ---
[INFO] Installing C:\Users\patry\Documents\GitHub\MyTask\pom.xml to C:\Users\patry\.m2\repository\com\task\start-project\1.0-SNAPSHOT\start-project-1.0-SNAPSHOT.pom
[INFO]
[INFO] --- docker-maven-plugin:1.2.1:build (default-cli) @ start-project ---
[INFO] Using authentication suppliers: [ConfigFileRegistryAuthSupplier]
[INFO] Property skipDockerBuild is set
[INFO] Skipping docker build
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for start-project 1.0-SNAPSHOT:
[INFO]
[INFO] springboot-credit .................................. SUCCESS [01:48 min]
[INFO] springboot-product ................................. SUCCESS [01:03 min]
[INFO] springboot-customer ................................ SUCCESS [01:06 min]
[INFO] start-project ...................................... SUCCESS [  0.604 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  03:59 min
[INFO] Finished at: 2019-11-24T19:59:17+01:00
[INFO] ------------------------------------------------------------------------
```

next
```
PS C:\Users\patry\Documents\GitHub\MyTask>docker-compose up
Pulling database (mysql/mysql-server:5.7)...
5.7: Pulling from mysql/mysql-server
a316717fc6ee: Pull complete                                                                                                           b64762744f75: Pull complete                                                                                                           a1f742e3aa43: Pull complete                                                                                                           f71a5f0dcc26: Pull complete                                                                                                           Digest: sha256:5396bc60a6c08abb6b7e8350b255324a91ee9f3ea11f009aea3e4b61ead38bf6
Status: Downloaded newer image for mysql/mysql-server:5.7
Creating database ... done                                                                                                            Creating customer ... done                                                                                                            Creating product  ... done                                                                                                            Creating credit   ... done                                                                                                            Attaching to database, product, customer, credit
database    | [Entrypoint] MySQL Docker Image 5.7.28-1.1.13
database    | [Entrypoint] Initializing database
product     |
product     |   .   ____          _            __ _ _
product     |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
product     | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
product     |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
product     |   '  |____| .__|_| |_|_| |_\__, | / / / /
product     |  =========|_|==============|___/=/_/_/_/
product     |  :: Spring Boot ::        (v2.1.5.RELEASE)
.
.
.
.
database    | [Entrypoint] running /docker-entrypoint-initdb.d/database.sql
database    |
database    |
database    | [Entrypoint] Server shut down
database    |
database    | [Entrypoint] MySQL init process done. Ready for start up.
database    |
database    | [Entrypoint] Starting MySQL 5.7.28-1.1.13
```

##Example service calls
Example POST: CreateCredit

![Post calling](./Image/Post.jpg)

Example GET: GetCredits
![Get calling](./Image/Get.jpg)

##Author
* Patrycja Dyszczakowska


