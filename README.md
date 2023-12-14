## Executor service

[![Java CI with Maven](https://github.com/Lokankara/Executor/actions/workflows/maven.yml/badge.svg)](https://github.com/Lokankara/Executor/actions/workflows/maven.yml)

#### Commands:

Clean, install, and generate report

`mvn clean install site -P test`

Test report

`mvn surefire-report:report`

Show dependency tree

`mvn dependency:tree`

Compile the code v.11 and package in file, skip the tests

`mvn clean package -DskipTests`

Build the project with Maven Tool

`mvn -B package --file pom.xml`

Run Tomcat server, show debug information

`mvn tomcat7:run -X`

Build the project with Maven Tool without Tests

`mvn clean install -e -DskipTests`

Build the project with Maven Tool with Tests

`mvn clean install -X`

Maven will perform the necessary build tasks, such as compiling the code,
creating the project's artifacts, and verifying their correctness.

`mvn verify -e`

Report with Jacoco Tool with Coverage

`mvn clean test jacoco:report`

worker has 2 objects scenario + proxy - listener
if you have 2: init driver, chrome + with config proxy (IP, username password)
chrome execute scenario
worker run async stream
work diff queue for multi must be multi-thread queue

controller service run worker if scenario + proxy
2 queues  
loop infinite read file scenario,
loop infinite read file proxy,
worker read 2 queues
if proxy empty waiting
worker run if 2 was 

handle if empty queues