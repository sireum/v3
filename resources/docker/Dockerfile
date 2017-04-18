FROM ubuntu:16.10
MAINTAINER Robby <robby@santoslab.org>
ENV SIREUM_HOME=/opt/sireum-v3 \
    JAVA_HOME=/opt/sireum-v3/platform/java \
    SCALA_HOME=/opt/sireum-v3/platform/scala \
    SBT_HOME=/opt/sireum-v3/platform/sbt \
    PATH=/opt/sireum-v3:/opt/sireum-v3/platform/java/bin:/opt/sireum-v3/platform/sbt/bin:/opt/sireum-v3/platform/scala/bin:/opt/sireum-v3/apps/z3/bin:$PATH
RUN locale-gen en_US en_US.UTF-8 && \
    dpkg-reconfigure locales && \
    dpkg --add-architecture i386 && \
    apt-get update && \
    apt-get install -y wget git unzip libgomp1 xz-utils build-essential automake cmake aspcud \
                       libc6-dev libgmp-dev libsodium-dev libc6-dev-i386 libgmp-dev:i386 libsodium-dev:i386 nano && \
    rm -rf /var/lib/apt/lists/* && \
    cd /opt && \
    git clone -b --recursive master https://github.com/sireum/v3.git sireum-v3 && \
    JAVA_OPTIONS="-Xmx2G -XX:+UseG1GC -XX:ReservedCodeCacheSize=1G -Xss2m -XX:+CMSClassUnloadingEnabled" && \
    $SIREUM_HOME/bin/sbt-launch.sh clean test:compile && \
    SIREUM_PARALLEL_BUILD=false && \
    $SIREUM_HOME/bin/sbt-launch.sh test && \
    sireum && \
    $SIREUM_HOME/bin/sbt-launch.sh clean && \
    git clone https://github.com/ksu-cis-706/compiler.git compiler && \
    cd /opt/compiler && \
    sbt clean test:compile test && \
    cd /opt && \
    rm -R compiler && \
    mkdir -p /opt/local/bin && \
    wget -q -O /opt/local/bin/opam https://github.com/ocaml/opam/releases/download/1.2.2/opam-1.2.2-x86_64-Linux && \
    chmod +x /opt/local/bin/opam && \
    rm ~/.profile && \
    echo 'export PATH=$PATH:/opt/local/bin' >> ~/.bashrc && \
    /opt/local/bin/opam init --jobs=4 --auto-setup --comp=4.04.0 && \
    cat ~/.profile >> ~/.bashrc && \
    rm ~/.profile && \
    /opt/local/bin/opam repo add coq-released https://coq.inria.fr/opam/released && \
    /opt/local/bin/opam pin add -n coq 8.5.2 && \
    /opt/local/bin/opam install --jobs=4 --yes coq
