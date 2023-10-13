# REST API
## Server

### Commands:

Clean, install, and generate report

`mvn clean install site -P test`

Test report

`mvn surefire-report:report`

Show dependency tree

`mvn dependency:tree`

Compile the code and package in file, skip the tests

`mvn clean package -DskipTests`

Build the project with Maven Tool

`mvn -B package --file pom.xml`

Compile the code and package in file, skip the tests

`mvn clean install -X`

Run Tomcat server, show debug information

`mvn tomcat7:run -X`
