FROM ubuntu:latest
RUN apt-get update && apt-get install -y openjdk-17-jdk maven openssh-server
RUN echo 'root:your_password' | chpasswd
RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config
RUN sed -i 's/#PasswordAuthentication yes/PasswordAuthentication yes/' /etc/ssh/sshd_config
EXPOSE 80 22
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn -B package --file pom.xml
FROM openjdk:17-slim
WORKDIR /app
COPY --from=0 /app/target/your-app-1.0-jar-with-dependencies.jar .
CMD ["/usr/sbin/sshd", "-D"]
CMD ["java", "-jar", "your-app-1.0-jar-with-dependencies.jar"]
