# Readme

## Requirements
 * to compile, make sure you have JDK 11 installed, available in PATH, and JAVA_HOME environment variable is set.
 * for execution this project requires Docker to be installed.
 
## How to compile & execute
 * in the root folder you can execute the ``./start.sh``
 * open the browser at [http://localhost:8080](http://localhost:8080)

**Alternatively** you can build and execute by:
 * build the Maven project by executing ``./mvnw clean install`` (if your OS is Mac or Linux) or ``mvnw.cmd clean install`` (on Windows).
 * run the project by executing ``docker-compose up``
 * open the browser at [http://localhost:8080](http://localhost:8080)

## How to compile & execute in DEVELOPMENT
 * in the root folder you can execute the ``./start-dev.sh`` to start MongoDb
 * use your preferred IDE to start the project, main class is ``server\src\main\kotlin\net\ionut\pets\PetsApplication.kt``
 * to start the front end execute the script ``ui/start-with-proxy.bat`` or execute the command inside this script

## About this project

### Server-side
 * was build using Java, Spring Boot and MariaDb.

### Front-end
 * I build an UI using Angular
