#!/bin/bash
USER="Pasha"

#create ssh keys
ssh-keygen -t rsa -b 4096 -C "fghjkl11@gmail.com" -f ~/.ssh/id_rsa -N ""
cat ~/.ssh/id_rsa.pub
xclip -sel clip < ~/.ssh/id_rsa.pub
echo "SSH key generated and public key copied to clipboard. Paste it to your remote virtual machine."

#refresh packages
sudo apt-get upgrade -y

#install java
sudo apt-get install -y openjdk-17-jdk
java -version

#install maven
sudo apt-get install -y maven
mvn -version

#install GUI and VNC server
sudo apt-get install -y xfce4 xfce4-goodies tigervnc-standalone-server
vncserver
vncpasswd -f <<< "password"
echo "[Unit]
Description=TigerVNC server
After=syslog.target network.target

[Service]
Type=forking
User=${USER}
ExecStartPre=/bin/sh -c '/usr/bin/vncserver -kill :1 > /dev/null 2>&1 || :'
ExecStart=/usr/bin/vncserver :1 -geometry 1280x720 -depth 24 -localhost no -nolisten tcp
ExecStop=/usr/bin/vncserver -kill :1

[Install]
WantedBy=multi-user.target" | sudo tee /etc/systemd/system/vncserver.service

#reload, enable and start the VNC service
sudo systemctl daemon-reload
sudo systemctl enable vncserver@1.service
vncserver -kill :1
sudo systemctl start vncserver@1
echo "VNC server installed. Connect to the VNC server using a VNC viewer on port 5901."

#install google chrome
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt-get install -y ./google-chrome-stable_current_amd64.deb

sudo apt-get -f install