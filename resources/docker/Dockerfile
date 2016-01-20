FROM ubuntu:14.04
MAINTAINER Robby <robby@santoslab.org>
RUN locale-gen en_US en_US.UTF-8 && \
    dpkg-reconfigure locales && \
    apt-get update && \
    apt-get install -y wget git unzip libgomp1 coq&& \
    rm -rf /var/lib/apt/lists/* && \
    cd /opt && \
    git clone https://github.com/sireum/v3.git sireum-v3 && \
    sireum-v3/bin/sbt-launch.sh clean test:compile test && \
    sireum-v3/sireum
ENV JAVA_HOME /opt/sireum-v3/platform/java
ENV PATH /opt/sireum-v3:/opt/sireum-v3/platform/java/bin:/opt/sireum-v3/apps/z3/bin:$PATH
