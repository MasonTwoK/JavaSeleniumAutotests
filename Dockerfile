FROM maven:3.9.3-amazoncorretto-17

# Install wget and unzip
RUN yum update -y && \
    yum install -y wget unzip

# Chrome browser
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm && \
    yum localinstall -y google-chrome-stable_current_x86_64.rpm && \
    rm -f google-chrome-stable_current_x86_64.rpm

# ChromeDriver
#RUN LATEST=$(wget -qO- https://chromedriver.storage.googleapis.com/LATEST_RELEASE) && \
    echo "Installing chromium webdriver version ${LATEST}" && \
    wget -N https://chromedriver.storage.googleapis.com/${LATEST}/chromedriver_linux64.zip -P ~/ && \
    unzip ~/chromedriver_linux64.zip -d ~/ && \
    rm ~/chromedriver_linux64.zip && \
    mv -f ~/chromedriver /usr/local/share/ && \
    chmod +x /usr/local/share/chromedriver && \
    ln -s /usr/local/share/chromedriver /usr/local/bin/chromedriver


# To check version of Chrome Driver and Chrome Browser
CMD ["chromedriver", "--version"]
# CMD ["google-chrome-stable", "--version"]

# ATTEMPT to install version that corespondence Chrome version \
# This version of chrome browser cannot be installed link: https://googlechromelabs.github.io/chrome-for-testing/#stable
# RUN wget -N https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/115.0.5790.102/linux64/chromedriver-linux64.zip -P ~/ && \
#    unzip ~/chromedriver_linux64.zip -d ~/ && \
#    rm ~/chromedriver_linux64.zip && \
#    mv -f ~/chromedriver /usr/local/share/ && \
#    chmod +x /usr/local/share/chromedriver && \
#    ln -s /usr/local/share/chromedriver /usr/local/bin/chromedriver

#COPY . /usr/src/mymaven
#WORKDIR /usr/src/mymaven

#RUN mvn dependency:resolve
#CMD ["mvn", "test"]
