#!/bin/bash
#
# Copyright (c) 2015, Robby, Kansas State University
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
#
# 1. Redistributions of source code must retain the above copyright notice, this
#    list of conditions and the following disclaimer.
# 2. Redistributions in binary form must reproduce the above copyright notice,
#    this list of conditions and the following disclaimer in the documentation
#    and/or other materials provided with the distribution.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
# ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
# WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
# DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
# ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
# (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
# ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
# (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
# SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
#
COMMANDS="wget unzip rm mv git"
for COMMAND in ${COMMANDS}; do
	type -P ${COMMAND} &>/dev/null && continue || { echo "${COMMAND} command not found; aborting..."; exit 1; }
done
ZULU_VERSION=1.8.0_66-8.11.0.1
SBT_VERSION=0.13.9
NODE_VERSION=5.3.0
Z3_VERSION=4.4.1
if [ -n "$COMSPEC" -a -x "$COMSPEC" ] || [ "${PLATFORM}" = "win"  ]; then
  PLATFORM=win
  ZULU_DROP_URL=http://cdn.azulsystems.com/zulu/bin/zulu${ZULU_VERSION}-win64.zip
  NODE_DROP_URL=https://nodejs.org/dist/v${NODE_VERSION}/win-x64/node.exe
  Z3_DROP_URL=https://github.com/Z3Prover/bin/raw/master/releases/z3-${Z3_VERSION}-x64-win.zip
elif [ "$(uname)" == "Darwin" ] || [ "${PLATFORM}" = "mac"  ]; then
  PLATFORM=mac
  ZULU_DROP_URL=http://cdn.azulsystems.com/zulu/bin/zulu${ZULU_VERSION}-macosx.zip
  NODE_DROP_URL=https://nodejs.org/dist/v${NODE_VERSION}/node-v${NODE_VERSION}-darwin-x64.tar.gz
  Z3_DROP_URL=https://github.com/Z3Prover/bin/raw/master/releases/z3-${Z3_VERSION}-x64-osx-10.11.zip
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ] || [ "${PLATFORM}" = "lin"  ]; then
  PLATFORM=lin
  ZULU_DROP_URL=http://cdn.azulsystems.com/zulu/bin/zulu${ZULU_VERSION}-x86lx64.zip
  NODE_DROP_URL=https://nodejs.org/dist/v${NODE_VERSION}/node-v${NODE_VERSION}-linux-x64.tar.gz
  Z3_DROP_URL=https://github.com/Z3Prover/bin/raw/master/releases/z3-${Z3_VERSION}-x64-ubuntu-14.04.zip
else
  echo "Sireum does not support: $(uname)"
  exit
fi
REPO=$( cd "$( dirname "$0" )"/.. &> /dev/null && pwd )
mkdir -p ${REPO}/platform
cd ${REPO}/platform
ZULU_DROP="${ZULU_DROP_URL##*/}"
ZULU_DIR="${ZULU_DROP%.*}"
grep -q ${ZULU_VERSION} java/VER &> /dev/null && ZULU_UPDATE=false || ZULU_UPDATE=true
if [ ! -d "java" ] || [ "${ZULU_UPDATE}" = "true" ]; then
  if [ ! -f ${ZULU_DROP} ]; then
    echo
    echo "Downloading ${ZULU_DROP}"
    echo
    wget --referer=http://www.azulsystems.com/products/zulu/downloads ${ZULU_DROP_URL}
  fi
  echo
  echo "Extracting ${ZULU_DROP}"
  unzip -oq ${ZULU_DROP}
  echo
  echo "Deleting ${ZULU_DROP}"
  rm ${ZULU_DROP}
  echo
  echo "Moving ${ZULU_DIR} to java"
  rm -fR java
  mv ${ZULU_DIR} java
  if [ -d "java/bin" ]; then
    echo "${ZULU_VERSION}" > java/VER
  else
    echo "Could not install Zulu JDK ${ZULU_VERSION}."
  fi
fi
SBT_DROP_URL=https://dl.bintray.com/sbt/native-packages/sbt/${SBT_VERSION}/sbt-${SBT_VERSION}.zip
SBT_DROP="${SBT_DROP_URL##*/}"
grep -q ${SBT_VERSION} sbt/VER &> /dev/null && SBT_UPDATE=false || SBT_UPDATE=true
if [ ! -d "sbt" ] || [ "${SBT_UPDATE}" = "true" ]; then
  if [ ! -f ${SBT_DROP} ]; then
    echo
    echo "Downloading ${SBT_DROP}"
    echo
    wget ${SBT_DROP_URL}
  fi
  echo
  echo "Extracting ${SBT_DROP}"
  rm -fR sbt
  unzip -oq ${SBT_DROP}
  echo
  echo "Deleting ${SBT_DROP}"
  rm ${SBT_DROP}
  if [ -d "sbt/bin" ]; then
    echo "${SBT_VERSION}" > sbt/VER
  else
    echo "Could not install Sbt ${SBT_VERSION}."
  fi
fi
grep -q ${NODE_VERSION} node/VER &> /dev/null && NODE_UPDATE=false || NODE_UPDATE=true
if [ ! -d "node" ] || [ "${NODE_UPDATE}" = "true" ]; then
  if [ "${PLATFORM}" = "win" ]; then
    NODE_DROP="${NODE_DROP_URL##*/}"
    echo
    echo "Creating node/bin"
    rm -fR node
    mkdir -p node/bin
    cd node/bin
    echo
    echo "Downloading ${NODE_DROP}"
    echo
    wget ${NODE_DROP_URL}
    cd ../..
    if [ -d "node/bin" ]; then
      echo "${NODE_VERSION}" > node/VER
    else
      echo "Could not install Node.js ${NODE_VERSION}."
    fi
  else
    NODE_DROP="${NODE_DROP_URL##*/}"
    NODE_DIR="${NODE_DROP%.tar.gz}"
    if [ ! -f ${NODE_DROP} ]; then
      echo
      echo "Downloading ${NODE_DROP}"
      echo
      wget ${NODE_DROP_URL}
    fi
    echo
    echo "Extracting ${NODE_DROP}"
    tar xfz ${NODE_DROP}
    echo
    echo "Deleting ${NODE_DROP}"
    rm ${NODE_DROP}
    echo
    echo "Moving ${NODE_DIR} to node"
    rm -fR node
    mv ${NODE_DIR} node
    if [ -d "node/bin" ]; then
      echo "${NODE_VERSION}" > node/VER
    else
      echo "Could not install Node.js ${NODE_VERSION}."
    fi
  fi
fi
mkdir -p ${REPO}/apps
cd ${REPO}/apps
Z3_DROP="${Z3_DROP_URL##*/}"
Z3_DIR="${Z3_DROP%.*}"
grep -q ${Z3_VERSION} z3/VER &> /dev/null && Z3_UPDATE=false || Z3_UPDATE=true
if [ ! -d "z3" ] || [ "${Z3_UPDATE}" = "true" ]; then
  if [ ! -f ${Z3_DROP} ]; then
    echo
    echo "Downloading ${Z3_DROP}"
    echo
    wget ${Z3_DROP_URL}
  fi
  echo
  echo "Extracting ${Z3_DROP}"
  unzip -oq ${Z3_DROP}
  echo
  echo "Deleting ${Z3_DROP}"
  rm ${Z3_DROP}
  echo
  echo "Moving ${Z3_DIR} to z3"
  rm -fR z3
  mv ${Z3_DIR} z3
  if [ -d "z3/bin" ]; then
    echo "${Z3_VERSION}" > z3/VER
  else
    echo "Could not install Z3 ${Z3_VERSION}."
  fi
fi
