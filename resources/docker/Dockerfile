FROM ubuntu:18.04
MAINTAINER Robby <robby@santoslab.org>
ENV SIREUM_HOME=/opt/sireum-v3 \
    JAVA_HOME=/opt/sireum-v3/platform/java \
    SCALA_HOME=/opt/sireum-v3/platform/scala \
    SBT_HOME=/opt/sireum-v3/platform/sbt \
    NODE_HOME=/opt/sireum-v3/platform/node \
    PATH=/opt/sireum-v3:/opt/sireum-v3/platform/java/bin:/opt/sireum-v3/platform/sbt/bin:/opt/sireum-v3/platform/scala/bin:/opt/sireum-v3/apps/z3/bin:/opt/sireum-v3/platform/node/bin:$PATH
RUN dpkg --add-architecture i386 && \
    apt-get update && apt-get install -y locales && \
    locale-gen en_US en_US.UTF-8 && \
    dpkg-reconfigure locales && \
    apt-get install -y wget git unzip libgomp1 xz-utils build-essential automake cmake aspcud curl python \
                       bc libc6-dev libgmp-dev libsodium-dev libc6-dev-i386 libgmp-dev:i386 libsodium-dev:i386 nano && \
    rm -rf /var/lib/apt/lists/* && \
    mkdir -p /opt/local/bin && \
    wget -q -O /opt/local/bin/opam https://github.com/ocaml/opam/releases/download/1.2.2/opam-1.2.2-x86_64-Linux && \
    chmod +x /opt/local/bin/opam && \
    rm ~/.profile && \
    echo 'export PATH=$PATH:/opt/local/bin' >> ~/.bashrc && \
    /opt/local/bin/opam init --jobs=4 --auto-setup --comp=4.05.0 && \
    cat ~/.profile >> ~/.bashrc && \
    rm ~/.profile && \
    /opt/local/bin/opam repo add coq-released https://coq.inria.fr/opam/released && \
    /opt/local/bin/opam pin add -n coq 8.7.1 && \
    /opt/local/bin/opam install --jobs=4 --yes coq && \
    cd /opt && \
    curl -O https://s3.amazonaws.com/mozilla-games/emscripten/releases/emsdk-portable.tar.gz && \
    tar xzf emsdk-portable.tar.gz && \
    rm -f emsdk-portable.tar.gz && \
    cd emsdk-portable && \
    ./emsdk update && \
    ./emsdk install latest && \
    ./emsdk activate latest && \
    cd /opt && \
    git clone --recursive -b master https://github.com/sireum/v3.git sireum-v3 && \
    $SIREUM_HOME/bin/sbt-launch.sh clean test:compile test:fastOptJS && \
    sireum && \
    $SIREUM_HOME/bin/sbt-launch.sh clean && \
    git clone https://github.com/ksu-cis-706/compiler.git compiler && \
    cd /opt/compiler && \
    sbt clean test:compile test && \
    cd /opt && \
    rm -R compiler
