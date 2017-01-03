FROM ubuntu:16.04
MAINTAINER Robby <robby@santoslab.org>
RUN locale-gen en_US en_US.UTF-8 && \
    dpkg-reconfigure locales && \
    apt-get update && \
    apt-get install -y wget git unzip libgomp1 xz-utils build-essential automake cmake libc6-dev libc6-dev-i386 aspcud && \
    rm -rf /var/lib/apt/lists/* && \
    cd /opt && \
    git clone -b master https://github.com/sireum/v3.git sireum-v3 && \
    git clone https://github.com/ksu-cis-706/compiler.git compiler && \
    sireum-v3/bin/prelude.sh && \
    cd /opt/compiler && \
    PATH=$PATH:/opt/sireum-v3/platform/java/bin /opt/sireum-v3/platform/sbt/bin/sbt clean test:compile test && \
    cd /opt && \
    rm -R compiler && \
    sireum-v3/bin/sbt-launch.sh clean test:compile test && \
    sireum-v3/sireum && \
    mkdir /opt/bin && \
    wget -q -O /opt/bin/opam https://github.com/ocaml/opam/releases/download/1.2.2/opam-1.2.2-x86_64-Linux && \
    chmod +x /opt/bin/opam && \
    rm ~/.profile && \
    echo 'export PATH=$PATH:/opt/bin' >> ~/.bashrc && \
    /opt/bin/opam init --no-setup --comp=4.04.0 && \
    echo '. /root/.opam/opam-init/init.sh > /dev/null 2> /dev/null || true' >> ~/.bashrc && \
    echo 'let () = try Topdirs.dir_directory (Sys.getenv "OCAML_TOPLEVEL_PATH") with Not_found -> () ;;' > ~/.ocamlinit && \
    /opt/bin/opam repo add coq-released https://coq.inria.fr/opam/released && \
    /opt/bin/opam pin add -n coq 8.5.2 && \
    /opt/bin/opam install --yes coq
ENV JAVA_HOME /opt/sireum-v3/platform/java
ENV PATH /opt/sireum-v3:/opt/sireum-v3/platform/java/bin:/opt/sireum-v3/apps/z3/bin:$PATH
