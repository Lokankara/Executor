FROM ubuntu:latest

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven openssh-server git \
    && echo 'root:your_password' | chpasswd \
    && sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config \
    && sed -i 's/#PasswordAuthentication yes/PasswordAuthentication yes/' /etc/ssh/sshd_config \
    && mkdir /app

WORKDIR /app

RUN echo "    ForwardAgent yes" >> /etc/ssh/ssh_config

RUN ssh-keygen -t rsa -b 4096 -C "fghjkl11@gmail.com" -f /root/.ssh/id_rsa -N ""

RUN cat /root/.ssh/id_rsa.pub

#RUN eval $(ssh-agent -s) && ssh-add /root/.ssh/id_rsa && git clone git@github.com:GFLCourses6/worker.git


COPY webdriver-qa-cluster.service-run.sh .
COPY setup.sh .

COPY pom.xml .
COPY src src

RUN mvn -B package --file pom.xml
RUN java -version

CMD ["/usr/sbin/sshd", "-D"]
CMD ["bash", "webdriver-qa-cluster.service-run.sh"]
CMD ["bash", "setup.sh"]
#CMD ["java", "-jar", "./target/executor-service-1.0-jar-with-dependencies.jar"]
