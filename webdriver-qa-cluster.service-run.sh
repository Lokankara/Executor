#!/bin/bash

SERVICE_NAME="webdriver-qa-cluster"
JAR_NAME="executor-service-1.0-SNAPSHOT-jar-with-dependencies.jar"

SERVICE_FILE="/etc/systemd/system/${SERVICE_NAME}.service"
RUN_FILE="$PWD/${SERVICE_NAME}-run.sh"

rm -r qa-cluster-e

git clone git@github.com:GFLCourses6/worker.git
cd /worker/executor-service

mvn clean compile assembly:single

if [ "`systemctl is-active $SERVICE_NAME`" != "active" ]; then
    echo "$SERVICE_NAME is not running ..."
else
    echo "$SERVICE_NAME stopping ..."
    systemctl stop ${SERVICE_NAME}
    echo "$SERVICE_NAME stopped ..."
    sleep 10
fi

echo "Creating new service ${SERVICE_FILE} ..."
echo "[Unit]" > ${SERVICE_FILE}
echo "Description=$SERVICE_NAME application service" >> ${SERVICE_FILE}
echo "[Service]" >> ${SERVICE_FILE}
echo "ExecStart=${RUN_FILE}" >> ${SERVICE_FILE}
echo "StandardOutput=null" >> ${SERVICE_FILE}
echo "StandardError=journal" >> ${SERVICE_FILE}
echo "SuccessExitStatus=143" >> ${SERVICE_FILE}
echo "TimeoutStopSec=10" >> ${SERVICE_FILE}
echo "Restart=on-failure" >> ${SERVICE_FILE}
echo "RestartSec=5" >> ${SERVICE_FILE}
echo "[Install]" >> ${SERVICE_FILE}
echo "WantedBy=multi-user.target" >> ${SERVICE_FILE}
chmod a+x ${SERVICE_FILE}

echo "Creating new run script ${RUN_FILE} ..."
echo "#!/bin/bash" > ${RUN_FILE}
echo "cd ${PWD}/target" >> ${RUN_FILE}
echo "sudo java -XX:+HeapDumpOnOutOfMemoryError -Xmx1024m -Xms128m -jar ${JAR_NAME}" >> ${RUN_FILE}
chmod a+x ${RUN_FILE}

echo "Starting service $SERVICE_NAME ..."
systemctl daemon-reload
systemctl enable ${SERVICE_NAME}
systemctl start ${SERVICE_NAME}

if [ "`systemctl is-active $SERVICE_NAME`" != "active" ]; then
    echo "WARNING!!! $SERVICE_NAME is not running!"
else
    echo "$SERVICE_NAME was started successfully!"
fi
