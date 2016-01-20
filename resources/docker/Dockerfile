FROM ubuntu:14.04
MAINTAINER Robby <robby@santoslab.org>
RUN locale-gen en_US en_US.UTF-8 && \
    dpkg-reconfigure locales && \
    apt-get update && \
    apt-get install -y build-essential wget git unzip libgomp1 coq python-pip software-properties-common && \
    rm -rf /var/lib/apt/lists/* && \
    pip install virtualenv && \
    pip install awscli==1.7.20 && \
    pip install glob2==0.4.1 && \
    pip install pika==0.9.14 && \
    tee /deps_updated.txt && \
    cd /opt && \
    git clone https://github.com/sireum/v3.git sireum-v3 && \
    sireum-v3/bin/sbt-launch.sh clean test:compile test && \
    sireum-v3/sireum && \
    chmod -R a+w sireum-v3
ENV JAVA_HOME /opt/sireum-v3/platform/java
ENV PATH /opt/sireum-v3:/opt/sireum-v3/platform/java/bin:/opt/sireum-v3/apps/z3/bin:$PATH
